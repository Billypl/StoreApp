package org.example.categoryservice.repository.event;

import java.util.UUID;

public interface EventRepository {
    void sendCreateCategoryEvent(UUID categoryId);

    void sendDeleteCategoryEvent(UUID categoryId);
}
