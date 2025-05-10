package com.musakan.core.entities.base;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private int version;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

/* CascadeType.PERSIST: Eğer ana nesne kaydedilirse, ilişkili nesne de kaydedilir.

   CascadeType.MERGE: Eğer ana nesne birleştirilirse (merge), ilişkili nesne de birleştirilir.

   CascadeType.REMOVE: Eğer ana nesne silinirse, ilişkili nesne de silinir.

   CascadeType.REFRESH: Eğer ana nesne yenilenirse (refresh), ilişkili nesne de yenilenir.

   CascadeType.DETACH: Eğer ana nesne ayrılırsa (detach), ilişkili nesne de ayrılır.

   CascadeType.ALL: genellikle ilişkili nesneler üzerinde yapılan tüm işlemlerin otomatik olarak
   senkronize edilmesini isteyen durumlarda kullanılır.   Bu, veri tutarlılığını korumak için
   faydalıdır ancak dikkat edilmesi gereken bir noktadır çünkü yanlışlıkla istemediğiniz işlemler
   yapılabilir (örneğin, ana nesne silindiğinde ilişkili nesnelerin de silinmesi).
 */