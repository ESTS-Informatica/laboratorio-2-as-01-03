
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class CompanyTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CompanyTest
{
    private Company company;
    private User client1;
    private User client2;
    private User seller1;
    private User seller2;
    private Property property1;
    private Property property2;
    private Sell sell1;
    private Sell sell2;
    /**
     * Default constructor for test class CompanyTest
     */
    public CompanyTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        company = new Company();
        client1 = new User("José Manuel", "911111111", "zemanel@yahoo.com");
        client2 = new User("António Francisco", "922222222", "tochico@hotmail.com");
        seller1 = new User("Fernando Fernandes", "966777101", "fefe@remax.pt");
        seller2 = new User("Rodrigo Rodrigues", "966777152", "roro@remax.pt");
        property1 = new Property("T3 Monte Belo", 150000.0);
        property2 = new Property("T1 Monte Belo", 80000.0);
        sell1 = new Sell(client1, seller1, property1);
        sell2 = new Sell(client2, seller2, property2);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void testConstructor(){
        assertNotEquals(null, company.getClients());
        assertNotEquals(null, company.getSellers());
        assertNotEquals(null, company.getProperties());
        assertNotEquals(null, company.getSells());
    }

    @Test
    public void testRegisterClient(){
        assertTrue(company.registerClient(client1));
    }

    @Test
    public void testRegisterClients(){
        assertTrue(company.registerClient(client1));
        assertTrue(company.registerClient(client2));
    }

    @Test
    public void testRegisterClientDuplicate(){
        company.registerClient(client1);
        assertFalse(company.registerClient(client1));
    }

    @Test
    public void testRegisterClientNull(){
        assertFalse(company.registerClient(null));
    }

    @Test
    public void testRegisterSeller(){
        assertTrue(company.registerSeller(seller1));
    }

    @Test
    public void testRegisterSellers(){
        assertTrue(company.registerSeller(seller1));
        assertTrue(company.registerSeller(seller2));
    }

    @Test
    public void testRegisterSellerDuplicate(){
        company.registerSeller(seller1);
        assertFalse(company.registerSeller(seller1));
    }

    @Test
    public void testRegisterSellerNull(){
        assertFalse(company.registerSeller(null));
    }

    @Test
    public void testRegisterProperty(){
        assertTrue(company.registerProperty(property1));
    }

    @Test
    public void testRegisterProperties(){
        assertTrue(company.registerProperty(property1));
        assertTrue(company.registerProperty(property2));
    }

    @Test
    public void testRegisterPropertyDuplicate(){
        company.registerProperty(property1);
        assertFalse(company.registerProperty(property1));
    }

    @Test
    public void testRegisterPropertyNull(){
        assertFalse(company.registerProperty(null));
    }

    @Test
    public void testCreateSell(){
        company.registerClient(client1);
        company.registerSeller(seller1);
        company.registerProperty(property1);
        assertTrue(company.createSell(client1, seller1, property1));
    }

    @Test
    public void testCalculateSellsOfTheYear(){
        company.registerSell(sell1);
        company.registerSell(sell2);
        assertEquals(2, company.calculateSellsOfTheYear(2024));
    }

    @Test
    public void testFindSellerOfTheYear(){
        company.registerClient(client1);
        company.registerSeller(seller1);
        company.registerProperty(property1);
        company.registerClient(client2);
        company.registerSeller(seller2);
        company.registerProperty(property2);
        company.registerSell(sell1);
        company.registerSell(sell2);
        assertEquals("Fernando Fernandes", company.findSellerOfTheYear(2024));
    }
}
