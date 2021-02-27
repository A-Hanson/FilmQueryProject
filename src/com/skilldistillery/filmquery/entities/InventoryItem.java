package com.skilldistillery.filmquery.entities;

import java.time.LocalDateTime;

public class InventoryItem {
	private int id;
	private int filmId;
	private int storeId;
	private String mediaCondition;
	private LocalDateTime lastUpdate;
	
	public InventoryItem() {
		super();
	}

	public InventoryItem(int id, int filmId, int storeId, String mediaCondition, LocalDateTime lastUpdate) {
		super();
		this.id = id;
		this.filmId = filmId;
		this.storeId = storeId;
		this.mediaCondition = mediaCondition;
		this.lastUpdate = lastUpdate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getMediaCondition() {
		return mediaCondition;
	}

	public void setMediaCondition(String mediaCondition) {
		this.mediaCondition = mediaCondition;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + filmId;
		result = prime * result + id;
		result = prime * result + ((lastUpdate == null) ? 0 : lastUpdate.hashCode());
		result = prime * result + ((mediaCondition == null) ? 0 : mediaCondition.hashCode());
		result = prime * result + storeId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InventoryItem other = (InventoryItem) obj;
		if (filmId != other.filmId)
			return false;
		if (id != other.id)
			return false;
		if (lastUpdate == null) {
			if (other.lastUpdate != null)
				return false;
		} else if (!lastUpdate.equals(other.lastUpdate))
			return false;
		if (mediaCondition == null) {
			if (other.mediaCondition != null)
				return false;
		} else if (!mediaCondition.equals(other.mediaCondition))
			return false;
		if (storeId != other.storeId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "InventoryItem [id=" + id + ", filmId=" + filmId + ", storeId=" + storeId + ", mediaCondition="
				+ mediaCondition + ", lastUpdate=" + lastUpdate + "]";
	}
	
	
}
