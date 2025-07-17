package my.projects

class Army {

    val warriors = mutableListOf<Warrior>()

    fun addUnits(amount: Int, warrior: () -> Warrior) {
        repeat(amount) {
            warriors.add(warrior())
        }
    }
}

fun fight(army1: Army, army2: Army): Boolean {
    var warrior1 = army1.warriors[0]
    var warrior2 = army2.warriors[0]

    while (army1.warriors.isNotEmpty() && army2.warriors.isNotEmpty()) {

        while (warrior1.isAlive() && warrior2.isAlive()) {
            warrior2.health -= warrior1.attack

            if (warrior2.isAlive()) {
                warrior1.health -= warrior2.attack
            }
        }

        if (!warrior1.isAlive()) {
            army1.warriors.removeFirst()
            if (army1.warriors.size == 0) {
                break
            }
            warrior1 = army1.warriors[0]

        } else {
            army2.warriors.removeFirst()
            if (army2.warriors.size == 0) {
                break
            }
            warrior2 = army2.warriors[0]
        }
    }
    return army1.warriors.isNotEmpty()
}

fun main() {
    val army1 = Army()
    val army2 = Army()

    army1.addUnits(2) { Knight() }
    army2.addUnits(2) { Warrior() }

    println(fight(army1, army2))
}
