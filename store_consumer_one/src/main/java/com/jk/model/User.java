package com.jk.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class User implements Serializable {
	
    private static final long serialVersionUID = -9070788065988855362L;

	private Integer userId;

    private String userName;

    private String userAccount;

    private String userPass;

    private String userPhone;

    private String userAddress;

    private Integer userType;

    private Integer userSex;

    private Integer userAge;

    private String userImg;

    private Integer userState;

    private Integer userLevel;

    private String userMail;

    private String userInfo;
    
    //时间展示字段
    private String showTime;
    
  //条件查询时间使用  
    private String createTimeStar;
    
    private String createTimeEnd;

    public String getCreateTimeStar() {
		return createTimeStar;
	}

	public void setCreateTimeStar(String createTimeStar) {
		this.createTimeStar = createTimeStar;
	}

	public String getCreateTimeEnd() {
		return createTimeEnd;
	}

	public void setCreateTimeEnd(String createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}

	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createTime;

    public List<User> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date loginTime;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date loginRecentlyTime;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date pastTime;

    private Integer hospitalId;
    
    private Integer loginCount;
    
    
    private List<User>  userlist;

    //批量修改使用
    private String ids;
    
    
    //====================角色字段====================
    
    private Integer roleId;

    private String roleName;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }
    
    //====================权限字段====================
    
    private Integer powerid;

    private String name;

    private String url;

    private Integer pid;

    private String target;

    public Integer getPowerid() {
        return powerid;
    }

    public void setPowerid(Integer powerid) {
        this.powerid = powerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target == null ? null : target.trim();
    }
    
    //====================用户 角色 关联字段====================
    
    
    
    //====================角色 权限 关联字段====================
    
    
    

    public Integer getUserId() {
        return userId;
    }

   

	public Date getLoginRecentlyTime() {
		return loginRecentlyTime;
	}

	public void setLoginRecentlyTime(Date loginRecentlyTime) {
		this.loginRecentlyTime = loginRecentlyTime;
	}

	public Integer getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass == null ? null : userPass.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress == null ? null : userAddress.trim();
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg == null ? null : userImg.trim();
    }

    public Integer getUserState() {
        return userState;
    }

    public void setUserState(Integer userState) {
        this.userState = userState;
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail == null ? null : userMail.trim();
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo == null ? null : userInfo.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getPastTime() {
        return pastTime;
    }

    public void setPastTime(Date pastTime) {
        this.pastTime = pastTime;
    }

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

	/* (non-Javadoc)    
	 * @see java.lang.Object#toString()    
	 */
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userAccount=" + userAccount + ", userPass="
				+ userPass + ", userPhone=" + userPhone + ", userAddress=" + userAddress + ", userType=" + userType
				+ ", userSex=" + userSex + ", userAge=" + userAge + ", userImg=" + userImg + ", userState=" + userState
				+ ", userLevel=" + userLevel + ", userMail=" + userMail + ", userInfo=" + userInfo + ", createTime="
				+ createTime + ", loginTime=" + loginTime + ", loginRecentlyTime=" + loginRecentlyTime + ", pastTime="
				+ pastTime + ", hospitalId=" + hospitalId + ", loginCount=" + loginCount + ", roleId=" + roleId
				+ ", roleName=" + roleName + ", powerid=" + powerid + ", name=" + name + ", url=" + url + ", pid=" + pid
				+ ", target=" + target + "]";
	}

	
    
}