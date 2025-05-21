package com.enaa.eventbookingapi.repositories;

import com.enaa.eventbookingapi.Model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepo extends JpaRepository<Event, Long> {
}
