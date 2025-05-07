package org.example.test.player;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayerTest {

    @Test
    public void looses_when_dice_number_is_to_low() {
        Dice dice = mock(Dice.class);
        when(dice.roll()).thenReturn(2);
        Player player = new Player(dice, 3);
        assertFalse(player.play());
    }

    @Test
    public void wins_when_dice_number_is_big() {
        Dice dice = mock(Dice.class);
        when(dice.roll()).thenReturn(5);
        Player player = new Player(dice, 3);
        assertTrue(player.play());
    }
}