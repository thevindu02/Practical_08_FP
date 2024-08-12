object CaeserCipher {

    //Encryption function

    def encrypt (plaintext:String, shift: Int): String = {

        plaintext.map {
             char => if(char.isLetter) {
                val base = if(char.isUpper) 'A' else 'a'

                ((char - base + shift ) % 26 + base).toChar
             }

             else
                {
                    char
                }
        }
    }

    //Decryption function
    def decrypt( ciperText: String, shift: Int): String = {

        ciperText.map {

            char => if(char.isLetter) {
                val base = if(char.isUpper) 'A' else 'a'
                ((char - base - shift + 26) % 26 + base).toChar
            }
            else
                {
                    char
                }
        }
    }

    //Cipher function
    def cipher( data:String, shift: Int, ciperFunc: (String, Int)  => String): String = {
        ciperFunc(data, shift)
    } 

    def main (args: Array[String]): Unit = {
        val plaintext = "Hello World!"
        val shift = 3

        val encryptedText = cipher(plaintext, shift, encrypt)
        println(s"Encrypted: $encryptedText")

        val decryptedText = cipher(encryptedText, shift, decrypt)
        println(s"Decrypted: $decryptedText")
    }
}