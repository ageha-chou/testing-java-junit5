package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Test Visit JpaService")
class VisitSDJpaServiceTest {

    @Mock
    private VisitRepository visitRepository;

    @InjectMocks
    private VisitSDJpaService service;

    @Test
    @DisplayName("Test Find All")
    void findAll() {
        Set<Visit> visits = new HashSet<>();
        visits.add(new Visit());

        when(visitRepository.findAll()).thenReturn(visits);
        Set<Visit> foundSet = service.findAll();
        assertThat(foundSet).hasSize(1);

        verify(visitRepository).findAll();
    }

    @Test
    @DisplayName("Test Find All BDD Style")
    void findAllBddStyle() {
        //given
        Set<Visit> visits = new HashSet<>();
        visits.add(new Visit());
        given(visitRepository.findAll()).willReturn(visits);

        //when
        Set<Visit> foundSet = service.findAll();

        //then
        assertThat(foundSet).hasSize(1);
        then(visitRepository).should().findAll();
    }

    @Test
    @DisplayName("Test Find By ID")
    void findById() {
        Visit visit = new Visit();
        when(visitRepository.findById(anyLong())).thenReturn(Optional.of(visit));
        Visit foundVisit = service.findById(1L);

        assertThat(foundVisit).isNotNull();

        verify(visitRepository).findById(anyLong());

    }

    @Test
    @DisplayName("Test Find By ID BDD Style")
    void findByIdBddStyle() {
        //given
        Visit visit = new Visit();
        given(visitRepository.findById(anyLong())).willReturn(Optional.of(visit));

        //when
        Visit foundVisit = service.findById(1L);

        //then
        assertThat(foundVisit).isNotNull();
        then(visitRepository).should().findById(anyLong());
    }

    @Test
    @DisplayName("Test Save")
    void save() {
        Visit visit = new Visit(1L);
        when(visitRepository.save(any(Visit.class))).thenReturn(visit);
        Visit savedVisit = service.save(visit);
        assertThat(savedVisit).isNotNull();
        verify(visitRepository).save(any(Visit.class));
    }

    @Test
    @DisplayName("Test Save BDD Style")
    void saveBddStyle() {
        //given
        Visit visit = new Visit(1L);
        given(visitRepository.save(any(Visit.class))).willReturn(visit);

        //when
        Visit savedVisit = service.save(visit);

        //then
        assertThat(savedVisit).isNotNull();
        then(visitRepository).should().save(any(Visit.class));
    }

    @Test
    @DisplayName("Test Delete")
    void delete() {
        service.delete(new Visit());
        verify(visitRepository).delete(any(Visit.class));
    }

    @Test
    @DisplayName("Test Delete BDD Style")
    void deleteBddStyle() {
        //when
        service.delete(new Visit());

        //then
        then(visitRepository).should().delete(any(Visit.class));
    }

    @Test
    @DisplayName("Test Delete By ID")
    void deleteById() {
        service.deleteById(1L);
        verify(visitRepository).deleteById(anyLong());
    }

    @Test
    @DisplayName("Test Delete By ID BDD Style")
    void deleteByIdBddStyle() {
        //when
        service.deleteById(1L);

        //then
        then(visitRepository).should().deleteById(anyLong());
    }
}