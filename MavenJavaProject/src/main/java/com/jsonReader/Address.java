package com.jsonReader;

public class Address {

	private int id ;
	
	private Type type;
	
	private AddressLineDetails addressLineDetail;
	
	private ProvinceOrState provinceOrState ;
	
	private Country country;
	
	private String lastUpdated;
	
	private String suburbOrDistrict;
	
	public class Type {
		
		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Type [code=" + code + ", name=" + name + "]";
		}

		public int code ;
		
		public String name;
		
		
	}
	
	public class AddressLineDetails {
		
		@Override
		public String toString() {
			return "AddressLineDetails [line1=" + line1 + ", line2=" + line2 + "]";
		}

		public String line1;
		
		public String line2;
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCityOrTown() {
		return cityOrTown;
	}

	public void setCityOrTown(String cityOrTown) {
		this.cityOrTown = cityOrTown;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public ProvinceOrState getProvinceOrState() {
		return provinceOrState;
	}

	public void setProvinceOrState(ProvinceOrState provinceOrState) {
		this.provinceOrState = provinceOrState;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public AddressLineDetails getAddressLineDetail() {
		return addressLineDetail;
	}

	public void setAddressLineDetail(AddressLineDetails addressLineDetail) {
		this.addressLineDetail = addressLineDetail;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getSuburbOrDistrict() {
		return suburbOrDistrict;
	}

	public void setSuburbOrDistrict(String suburbOrDistrict) {
		this.suburbOrDistrict = suburbOrDistrict;
	}
	
	@Override
	public String toString() {
		return "Address [ Type :" + type + "\n"+", Line Detail -" + addressLineDetail
				+ "\n" + ", City - " + cityOrTown 
				+ "\n" + ", provinceOrState - " + provinceOrState 
				+ "\n" + ", country=" + country 
				+ "\n" + ", postalCode - " + postalCode
				+ "]";
	}

	public class ProvinceOrState {
		
		@Override
		public String toString() {
			return "ProvinceOrState [code=" + code + ", name=" + name + "]";
		}

		public int code ;
		
		public String name;
		
	}
	
	public String cityOrTown;
	
	public class Country {
		
		@Override
		public String toString() {
			return "Country [code=" + code + ", name=" + name + "]";
		}

		public String code ;
		
		public String name;
		
	}
	
	public String postalCode;

}
