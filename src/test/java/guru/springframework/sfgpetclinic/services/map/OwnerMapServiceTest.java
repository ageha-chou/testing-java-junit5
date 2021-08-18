package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Owner Map Service Test - ")
class OwnerMapServiceTest {
    private PetTypeService petTypeService;
    private PetService petService;
    private OwnerMapService ownerMapService;

    @BeforeEach
    void setUp() {
        petTypeService = new PetTypeMapService();
        petService = new PetMapService();
        ownerMapService = new OwnerMapService(petTypeService, petService);

        System.out.println(">> First Before Each");
    }

    @Test
    @DisplayName("Verify Zero Owners")
    void ownerAreZero() {
        int ownerCount = ownerMapService.findAll().size();
        assertEquals(0, ownerCount);
    }

    @DisplayName("Pet Type - ")
    @Nested
    class TestCreatedPetTypes {
        @BeforeEach
        void setUp() {
            petTypeService.save(new PetType(1L, "Dog"));
            petTypeService.save(new PetType(2L, "Cat"));

            System.out.println(">> Nested Before Each");
        }

        @Test
        void testPetCount() {
            int petTypeCount = petTypeService.findAll().size();
            assertEquals(2, petTypeCount);
        }

        @DisplayName("Save owners tests - ")
        @Nested
        class SaveOwnersTests {
            @BeforeEach
            void setUp() {
                ownerMapService.save(new Owner(1L, "Before", "Each"));
                System.out.println(">> Saved Owner Before Each");
            }

            @Test
            void saveOwner() {
                Owner owner = new Owner(2L, "Joe", "Buck");
                Owner savedOwner = ownerMapService.save(owner);
                assertNotEquals(null, savedOwner);
            }

            @DisplayName("Save Owners Tests - ")
            @Nested
            class FindOwnersTests {

                @DisplayName("Find Owner")
                @Test
                void findOwner() {

                    Owner foundOwner = ownerMapService.findById(1L);

                    assertNotEquals(null, foundOwner);
                }

                @DisplayName("Find Owner Not Found")
                @Test
                void findOwnerNotFound() {

                    Owner foundOwner = ownerMapService.findById(2L);

                    assertEquals(null, foundOwner);
                }
            }
        }
    }


    @DisplayName("Verify Still Zero Owner")
    @Test
    void ownersAreStillZero() {
        int ownerCount = ownerMapService.findAll().size();
        assertEquals(0, ownerCount);
    }
}