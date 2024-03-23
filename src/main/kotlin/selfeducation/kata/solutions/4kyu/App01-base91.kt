import org.apache.tomcat.util.codec.binary.Base64

fun main() {
    println(Base91.encode("test"))
    Base91.alphabet.forEachIndexed{idx, letter -> println("$idx = $letter") }
    val x1 = 3724/91
    val x2 = 3724%91
    println()
//   1000001.1000010.1000011.1000100.1000101.1000110.1000111.1001000.1001001.1001010.1001011.1001100.1001101.1001110.1001111.1010000.1010001.1010010.1010011.1010100.1010101.1010110.1010111.1011000.1011001.1011010.1100001.1100010.1100011.1100100.1100101.1100110.1100111.1101000.1101001.1101010.1101011.1101100.1101101.1101110.1101111.1110000.1110001.1110010.1110011.1110100.1110101.1110110.1110111.1111000.1111001.1111010.110000.110001.110010.110011.110100.110101.110110.110111.111000.111001.100001.100011.100100.100101.100110.101000.101001.101010.101011.101100.101110.101111.111010.111011.111100.111101.111110.111111.1000000.1011011.1011101.1011110.1011111.1100000.1111011.1111100.1111101.1111110.1011100

//    01110100.01100101.01110011.01110100

//    01110100.01100101
}



object Base91 {

    val alphabet = """ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!#$%&()*+,./:;<=>?@[]^_`{|}~\"""

    fun encode(data: String): String {
        val bytes = data.toByteArray()
        val binary = bytes.joinToString(".") { Integer.toBinaryString(it.toInt()).padStart(8, '0') }

        return Base64.encodeBase64String(data.toByteArray())
    }
    fun decode(data: String): String {
        return Base91.decode(data)// do it!
    }

//    @Test
//    fun fixedTests() {
//        assertEquals(Base91.encode("test"), "fPNKd")
//        assertEquals(Base91.encode("Hello World!"), ">OwJh>Io0Tv!8PE")
//        assertEquals(Base91.decode("fPNKd"), "test")
//        assertEquals(Base91.decode(">OwJh>Io0Tv!8PE"), "Hello World!")
//    }
}