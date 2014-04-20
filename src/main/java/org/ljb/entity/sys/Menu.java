package org.ljb.entity.sys;

public class Menu {

	private Integer id;
	private String name;
	private String displayName;
	private Integer parentId;
	private Integer useFlag;
	private Integer sequence;
	
	public Menu(){
		
	}
	
	public Menu(String name, String displayName, Integer parentId,
			Integer useFlag) {
		super();
		this.id = id;
		this.name = name;
		this.displayName = displayName;
		this.parentId = parentId;
		this.useFlag = useFlag;
		this.sequence = sequence;
	}
	
	public Menu(Integer id, String name, String displayName, Integer parentid,
			Integer useFlag, Integer sequence) {
		super();
		this.id = id;
		this.name = name;
		this.displayName = displayName;
		this.parentId = parentid;
		this.useFlag = useFlag;
		this.sequence = sequence;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public Integer getParentid() {
		return parentId;
	}
	public void setParentid(Integer parentid) {
		this.parentId = parentid;
	}
	public Integer getuseFlag() {
		return useFlag;
	}
	public void setuseFlag(Integer useFlag) {
		this.useFlag = useFlag;
	}
	public Integer getSequence() {
		return sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	
	

}
