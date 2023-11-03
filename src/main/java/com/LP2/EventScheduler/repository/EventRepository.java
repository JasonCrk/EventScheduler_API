package com.LP2.EventScheduler.repository;

import com.LP2.EventScheduler.model.Event;
import com.LP2.EventScheduler.model.User;
import com.LP2.EventScheduler.repository.custom.SearchEventsRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EventRepository extends JpaRepository<Event, UUID>, SearchEventsRepository {
    @Query("SELECT e FROM Event e WHERE e.coordinator = :user AND e.visibility = 'PUBLIC'")
    List<Event> findPublicEventsByUser(@Param("user") User user);
}
