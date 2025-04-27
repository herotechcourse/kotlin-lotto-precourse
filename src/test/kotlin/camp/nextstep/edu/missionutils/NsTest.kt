package camp.nextstep.edu.missionutils

import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.PrintStream

abstract class NsTest {
    private lateinit var systemOut: ByteArrayOutputStream
    private lateinit var systemIn: InputStream

    protected abstract fun run()

    protected fun run(vararg args: String) {
        systemOut = ByteArrayOutputStream()
        systemIn = makeInputStream(*args)

        System.setIn(systemIn)
        System.setOut(PrintStream(systemOut))

        run()

        Console.close()
    }

    protected fun output(): String {
        return systemOut.toString().trim()
    }

    protected fun runException(vararg args: String) {
        systemOut = ByteArrayOutputStream()
        systemIn = makeInputStream(*args)

        System.setIn(systemIn)
        System.setOut(PrintStream(systemOut))

        try {
            run()
        } catch (_: IllegalArgumentException) {
            // expected
        }

        Console.close()
    }

    private fun makeInputStream(vararg args: String): InputStream {
        return ByteArrayInputStream(args.joinToString("\n").toByteArray())
    }
}
