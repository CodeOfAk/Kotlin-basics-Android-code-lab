fun main(){
   val dice1 = Dice(50)
   println("Your ${dice1.sides} sided dice rolled ${dice1.roll()}")
   
   val coin1 = Coin()
   println("It is ${coin1.flip()}")
}

class Dice(val sides: Int){
    
    fun roll(): Int {
        return (1..sides).random()
    }
}

class Coin(){
    
    fun flip(): String {
        val randomNumber = (1..2).random()
        val itIs = when(randomNumber){
            1 -> "Heads"
            2 -> "Tails"
            else -> {"oops"}
        }
        return itIs
    }
}
