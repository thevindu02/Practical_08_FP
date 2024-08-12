import  scala.io.StdIn.readInt

object NumberCategorizer {

    def main ( args: Array[String]): Unit = {

    
        try {

                println("Please enter a positive integer:")

                val number = readInt()

                if( number > 0)
                {
                    //Lambda functions
                    val multipleOfThree : Int => String = n => if(n % 3 == 0) "Multiple of Three " else ""
                    val multipleOfFive: Int => String = n => if(n % 5 == 0) "Multiple of Five" else ""
                    val multipleOfBoth: Int => String = n => if(n % 3 == 0 && n % 5 == 0) "Multiple of Three and Five" else ""
                    val notMultiple: Int => String = _ => "Not a Multiple of Three or Five"

                    //Pattern matching 
                    val message = number match {

                        case n if multipleOfBoth(n).nonEmpty => multipleOfBoth(n)
                        case n if multipleOfThree(n).nonEmpty => multipleOfThree(n)
                        case n if multipleOfFive(n).nonEmpty => multipleOfFive(n)
                        case _ => notMultiple(number)
                    }


                println(message)

                }
                else
                    {
                        println("Number entered is not a positive integer")
                    }
                


        } catch {

            case _: NumberFormatException => println("Please enter a valid integer")

        }



        


    }


        

}
