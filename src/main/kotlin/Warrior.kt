package my.projects

open class Warrior {

    var health: Int = 50
    open val attack: Int = 5

    fun isAlive(): Boolean {
        return health > 0
    }
}

class Knight : Warrior() {
    override val attack: Int = 7
}

fun fight(warrior1: Warrior, warrior2: Warrior): Boolean {

    while (warrior1.isAlive() && warrior2.isAlive()) {
        warrior2.health -= warrior1.attack

        if (warrior2.isAlive()) {
            warrior1.health -= warrior2.attack
        }
    }
    return warrior1.isAlive()
}

fun main() {
    val warrior1 = Warrior()
    val warrior2 = Knight()

    println(fight(warrior1, warrior2))
}
