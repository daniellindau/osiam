package org.osiam.storage.entities;

import javax.persistence.*;

/**
 * Defines a value of a field of a scim-extension. It's user-dependent!
 */
@Entity(name = "scim_extension_field_value")
public class ExtensionFieldValueEntity {

    @Id
    @GeneratedValue
    @Column(name = "internal_id")
    private long internalId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "extension_field_internal_id")
    private ExtensionFieldEntity extensionField;

    @ManyToOne(optional = false)
    private UserEntity user;

    @Lob
    @Column(nullable = false)
    private String value;

    public long getInternalId() {
        return internalId;
    }

    public void setInternalId(long internalId) {
        this.internalId = internalId;
    }

    public ExtensionFieldEntity getExtensionField() {
        return extensionField;
    }

    public void setExtensionField(ExtensionFieldEntity extensionField) {
        this.extensionField = extensionField;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((extensionField == null) ? 0 : extensionField.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ExtensionFieldValueEntity other = (ExtensionFieldValueEntity) obj;
        if (extensionField == null) {
            if (other.extensionField != null) {
                return false;
            }
        } else if (!extensionField.equals(other.extensionField)) {
            return false;
        }
        return true;
    }

}


