fun main() {
	val luckyNumber = readLine()?.toInt()
    val dice1 = Dice(6)
    val rollResult = dice1.roll()
    println("Dice Rolled : $rollResult")

    winRandom()
    looseRandom()

    if(luckyNumber == rollResult){
        println("${winRandom()}! You guessed right.")
    }
    else{
        println("${looseRandom()}! You guessed wrong")
    }


    
}

// function to generate random greeting
fun winRandom(): String{
    val randomWin = (1..4).random()
    val x = when(randomWin){
        1-> "Cangratulations"
        2-> "WOW"
        3-> "Hurray"
        4-> "Fabulous"
        else-> {"oops"}
    }
    return x

}

//To generate random sad words
fun looseRandom(): String{
    val randomLoose = (1..4).random()
    val y =when(randomLoose){
        1-> "OOPS"
        2-> "Sorry"
        3-> "Soo Sad"
        4-> "Try Again"
        else-> {"oops"}
    }
    return y
}

class Dice(val sides: Int){

    fun roll():Int{
        return (1..sides).random()
    }
}
