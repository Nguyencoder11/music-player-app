/*
 * Transaction.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.app.msplayer.entity;

import com.app.msplayer.enums.EntityType;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

/**
 * Transaction.java
 *
 * @author Nguyen
 */
@Entity
@Table(name = "transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long transactionId;

    @Enumerated(EnumType.STRING)
    @Column(name = "entity_type", nullable = false)
    private EntityType entityType;

    @Column(name = "entity_id")
    private UUID entityId;

    @Column(name = "field_name", nullable = false, length = 50)
    private String fieldName;

    @Column(name = "language", nullable = false, length = 10)
    private String language;

    @Column(name = "translated_value", nullable = false)
    private String translatedValue;
}
