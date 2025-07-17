import my.projects.Army
import my.projects.Warrior
import my.projects.fight
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ArmyTest {

    @Test
    fun `1 Battle`() {
        val army1 = Army()
        val army2 = Army()

        army1.addUnits(1) { Warrior() }
        army2.addUnits(2) { Warrior() }

        assertFalse(fight(army1, army2))
    }

    @Test
    fun `2 Battle`() {
        val army1 = Army()
        val army2 = Army()

        army1.addUnits(2) { Warrior() }
        army2.addUnits(3) { Warrior() }

        assertFalse(fight(army1, army2))
    }

    @Test
    fun `3 Battle`() {
        val army1 = Army()
        val army2 = Army()

        army1.addUnits(5) { Warrior() }
        army2.addUnits(7) { Warrior() }

        assertFalse(fight(army1, army2))
    }

    @Test
    fun `4 Battle`() {
        val army1 = Army()
        val army2 = Army()

        army1.addUnits(20) { Warrior() }
        army2.addUnits(21) { Warrior() }

        assertTrue(fight(army1, army2))
    }

    @Test
    fun `5 Battle`() {
        val army1 = Army()
        val army2 = Army()

        army1.addUnits(10) { Warrior() }
        army2.addUnits(11) { Warrior() }

        assertTrue(fight(army1, army2))
    }

    @Test
    fun `6 Battle`() {
        val army1 = Army()
        val army2 = Army()

        army1.addUnits(11) { Warrior() }
        army2.addUnits(7) { Warrior() }

        assertTrue(fight(army1, army2))
    }
}
