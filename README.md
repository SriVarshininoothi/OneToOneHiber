## 📘 Project Overview

This project demonstrates a One-to-One relationship between two entities — Customer and Address — using Hibernate ORM and JPA annotations.

Each Customer is linked to one Address, and each Address belongs to exactly one Customer.

The project covers:

Hibernate configuration with XML

Entity creation using JPA annotations

One-to-One mapping using @OneToOne and @JoinColumn

CRUD operations with Hibernate Session

Cascade operations between related entities

## 🧠 Concept: One-to-One Mapping

A One-to-One relationship means that one record in a table is associated with one record in another table.

Example:

One Customer → One Address
One Address → One Customer

In Hibernate, this is represented using @OneToOne.
