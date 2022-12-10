package com.scratchy.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.scratchy.entity.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlotRepository extends JpaRepository<Slot, Long> {

  List<Slot> findAllByPractitionerIdAndTimeBetween(
      long practitionerId, LocalDateTime from,
      LocalDateTime to);

  List<Slot> findAllByPractitionerIdAndTimeBetweenAndFreeIsTrue(
      long practitionerId, LocalDateTime from,
      LocalDateTime to);
}
