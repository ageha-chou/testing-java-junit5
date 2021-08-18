package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.SpecialtyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SpecialitySDJpaServiceTest {

    @Mock
    private SpecialtyRepository specialtyRepository;

    @InjectMocks //Mockito creates an instance of this and inject it
    private SpecialitySDJpaService service;

    @Test
    void testDeleteByObject() {
        //create new Speciality object that our mock will return
        Speciality speciality = new Speciality();

        service.delete(speciality);

        verify(specialtyRepository).delete(any(Speciality.class));
    }

    @Test
    void findById() {
        //create new Speciality object that our mock will return
        Speciality speciality = new Speciality();

        //when specialtyRepository findById() is called
        //-> return the Speciality object that we created on line 27
        when(specialtyRepository.findById(1L)).thenReturn(Optional.of(speciality));

        //make an actual call -> assign Speciality obj on line 27 to foundSpecialty
        Speciality foundSpecialty = service.findById(1L);

        assertThat(foundSpecialty).isNotNull();

        //make sure findById() only call once
        verify(specialtyRepository).findById(anyLong());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        service.deleteById(1L);

        verify(specialtyRepository, times(2)).deleteById(1L);
    }

    @Test
    void deleteAtLeast() {
        service.deleteById(1L);
        service.deleteById(1L);

        verify(specialtyRepository, atLeastOnce()).deleteById(1L);
    }

    @Test
    void deleteAtMost() {
        service.deleteById(1L);
        service.deleteById(1L);

        verify(specialtyRepository, atMost(5)).deleteById(1L);
    }

    @Test
    void testDelete() {
        service.delete(new Speciality());
    }
}