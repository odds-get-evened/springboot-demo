package gov.ny.its.mentor_demo.entity;

import jakarta.persistence.*;

@Entity
public class Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "asset_name")
	private String assetName;

	@Column(name = "id_code")
	private String idCode;

	@Column(name = "is_active")
	private Integer isActive;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public String getIdCode() {
		return idCode;
	}

	public void setIdCode(String idCode) {
		this.idCode = idCode;
	}
}
