package ohtu.NhlStatistics;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;
import ohtuesimerkki.*;

public class StatisticsTest {
 
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp() {
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }  

	@Test
	public void searchFindWorks() {
		assertEquals(stats.search("Semenko").getName(), "Semenko");
	}

	@Test
	public void searchNoFindWorks() {
		assertEquals(stats.search("Ilmo"), null);
	}

	@Test
	public void teamGivesRightAmount() {
		assertEquals(stats.team("EDM").size(), 3);
	}

	@Test
	public void noTeamGivesZero() {
		assertEquals(stats.team("ASD").size(), 0);
	}

	@Test
	public void topScorerWorks() {
		assertEquals(stats.topScorers(2).get(0).getName(), "Gretzky");
		
	}


}
