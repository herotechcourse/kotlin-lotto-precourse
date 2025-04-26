const { execSync } = require("child_process");
const fs = require("fs");

const GIT_URL = "https://github.com/yourname/yourrepo"; // <-- CHANGE THIS
const OUTPUT_FILE = "CHANGELOG.md";

// Get last tag, fallback to all history
let lastTag;
try {
  lastTag = execSync("git describe --tags --abbrev=0", { encoding: "utf-8" }).trim();
} catch {
  lastTag = ""; // No tags yet
}

const range = lastTag ? `${lastTag}..HEAD` : "";
const log = execSync(`git log ${range} --pretty=format:%H%n%B%n---END---`, { encoding: "utf-8" });

const commits = log.split("---END---\n").filter(Boolean).map(entry => {
  const lines = entry.trim().split("\n");
  const hash = lines.shift();
  const typeMatch = lines[0].match(/^(\w+)(?:\(([^)]+)\))?: (.+)$/);
  if (!typeMatch) return null;

  const [, type, scope = "", subject] = typeMatch;
  const bodyLines = [];
  const footerLines = [];

  let inFooter = false;
  for (let i = 1; i < lines.length; i++) {
    const line = lines[i];
    if (/^(BREAKING CHANGE:|Closes )/.test(line)) inFooter = true;
    if (inFooter) footerLines.push(line);
    else bodyLines.push(line);
  }

  return {
    hash,
    type,
    scope,
    subject,
    body: bodyLines.join("\n").trim(),
    footer: footerLines.join("\n").trim()
  };
}).filter(Boolean);

// Group by type
const grouped = {};
const TYPES = ["feat", "fix", "docs", "style", "refactor", "test", "chore"];

TYPES.forEach(t => grouped[t] = []);
commits.forEach(c => {
  if (TYPES.includes(c.type)) grouped[c.type].push(c);
});

// Format section
function formatSection(type, commits) {
  if (!commits.length) return "";
  const emojiMap = {
    feat: "🚀 Features",
    fix: "🐛 Bug Fixes",
    docs: "📚 Documentation",
    style: "🎨 Style",
    refactor: "🔧 Refactors",
    test: "🧪 Tests",
    chore: "🛠️ Maintenance"
  };
  let output = `### ${emojiMap[type]}\n\n`;
  commits.forEach(({ hash, scope, subject, body, footer }) => {
    const header = `- **${scope}**: ${subject} ([${hash.slice(0, 7)}](${GIT_URL}/commit/${hash}))`;
    const details = [body, footer].filter(Boolean).map(s => `  > ${s.replace(/\n/g, "\n  > ")}`).join("\n");
    output += `${header}\n${details ? details + "\n" : ""}\n`;
  });
  return output;
}

// Build changelog
const version = new Date().toISOString().split("T")[0];
let changelog = `## ${version}\n\n`;

TYPES.forEach(type => {
  changelog += formatSection(type, grouped[type]);
});

// Write changelog
fs.appendFileSync(OUTPUT_FILE, changelog + "\n");
console.log(`✅ ${OUTPUT_FILE} updated from ${lastTag || "start"} to HEAD`);
