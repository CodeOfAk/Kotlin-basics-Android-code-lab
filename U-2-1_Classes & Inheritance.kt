import kotlin.math.PI
import kotlin.math.sqrt



fun main() {

    val squareCabin = SquareCabin(6, 5.0)

    // it is like -- squareCabin.capacity and so on
    with (squareCabin){
        println("\nSquare Cabin\n==============")
        println("Capacity: ${capacity}")
        println("Material: ${buildingMaterial}")
        println("Has Room? :${hasRoom()}")
        //println("Floor Area:${floorArea()}")
        println("Floor Area:%.2f".format(floorArea()))
        getRoom()
        println("Has Room? :${hasRoom()}")
    }

    val roundHut = RoundHut(3,10.0)

    with (roundHut){
        println("\nSquare Cabin\n==============")
        println("Capacity: ${capacity}")
        println("Material: ${buildingMaterial}")
        println("Has Room? :${hasRoom()}")
        println("Floor Area:%.2f".format(floorArea()))
        getRoom()
        println("Has Room? :${hasRoom()}")
        println("Carpet Size: ${calculateMaxCarpetSize()}")
    }

    val roundTower = RoundTower(4,15.4,3)

    with (roundTower){
       println("\nSquare Cabin\n==============")
       println("Capacity: ${capacity}")
       println("Material: ${buildingMaterial}")
       println("Has Room? :${hasRoom()}")
       println("Floor Area:%.2f".format(floorArea()))
       getRoom()
       println("Has Room? :${hasRoom()}")
       println("Carpet Size: ${calculateMaxCarpetSize()}")
    }
	
}

//Creating abstract class-- Dwelling
abstract class Dwelling(private var residents: Int){
    abstract val buildingMaterial: String
    abstract val capacity: Int

    fun hasRoom(): Boolean {
        return residents < capacity
    }

    abstract fun floorArea(): Double

    fun getRoom(){
        if(capacity > residents){
            residents++
            println("You got the room!")
        }
        else{
            println("Sorry, It is full and no room left.")
        }
    }
}

//Creating subclass -- SquareCabin  [subclass of Dwelling() class]
class SquareCabin(residents : Int, var length: Double) : Dwelling(residents) {
    override val buildingMaterial = "Wood"
    override val capacity = 6

    //overriding function -- floorArea() 
    override fun floorArea(): Double{
        return length * length
    }
}

// Creating subclass -- RoundHut  [subclass of Dwelling() class]
open class RoundHut(residents: Int, var radius: Double) : Dwelling(residents){
    override val buildingMaterial = "Straw"
    override val capacity = 4
    
    //overriding function -- floorArea()
    override fun floorArea(): Double{
        return PI * radius * radius
    }

    //calculating Carpet Area
    fun calculateMaxCarpetSize(): Double{
        val diameter = 2* radius
        return sqrt(diameter*diameter/2)
    }

}

// Creating subclass -- RoundTower  [subclass of RoundHut() class]

class RoundTower(residents: Int, radius: Double, val floors: Int) : RoundHut(residents, radius){
    override val buildingMaterial = "Stone"
    override val capacity = 4 * floors

    //overriding function-- floorArea()
    /*Notice:- There is no need to to override this function as it is subclass of RoundHut
    which already has overriden floorArea() function  */
    //But roundTower is multistorey..
    /*
    override fun floorArea(): Double{
        return Pi*radius*radius*floors
    }
    */
    //--------------OR-------------//
    //call floorArea() function and multiply it by floors

    override fun floorArea(): Double{
        return super.floorArea() * floors
    }


}
