package edu.vsem.model;/*
  @author   Radyslav Churkin
  @project   course-project
  @class  item
  @version  1.0.0 
  @since 18.07.2021 - 18.31
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private String id;
    private String name;
    private String desc;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return getId().equals(item.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }


}
