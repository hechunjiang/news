package com.news.mobilephone.entiyt;

/**
 * Created by sfy. on 2018/11/2 0002.
 */

public class TempleLoginResponse {


    /**
     * code : 200
     * msg :
     * data : {"ticket":"sHp2r312otmCpnGns3mCqJhovNiBh4Pbr5iNbbOlf8yxsI-hfYaqlI65hpjAdYachKOzl393gNC64H1rwM5-l62jra6KZM3XjZSKo7-Ik2uRo6zWlGWLoQ","login_flag":false,"user_info":{"id":64201,"c_user_id":76698,"nickname":"","status":1,"grade_id":0,"sex":1,"headimg":"","user_father_id":0,"user_grandfather_id":0,"invitation_code":"T55220","birthday":"","lat":0,"lng":0,"gold_flag":0,"total_gold_flag":0,"frozen_gold_flag":0,"balance":"0.00","total_balance":"0.00","frozen_balance":"0.00","oredstatus":0,"redcash":0,"create_time":1541142136,"is_cross_read_level":0}}
     */

    private String code;
    private String msg;
    private DataBean data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * ticket : sHp2r312otmCpnGns3mCqJhovNiBh4Pbr5iNbbOlf8yxsI-hfYaqlI65hpjAdYachKOzl393gNC64H1rwM5-l62jra6KZM3XjZSKo7-Ik2uRo6zWlGWLoQ
         * login_flag : false
         * user_info : {"id":64201,"c_user_id":76698,"nickname":"","status":1,"grade_id":0,"sex":1,"headimg":"","user_father_id":0,"user_grandfather_id":0,"invitation_code":"T55220","birthday":"","lat":0,"lng":0,"gold_flag":0,"total_gold_flag":0,"frozen_gold_flag":0,"balance":"0.00","total_balance":"0.00","frozen_balance":"0.00","oredstatus":0,"redcash":0,"create_time":1541142136,"is_cross_read_level":0}
         */

        private String ticket;
        private boolean login_flag;
        private UserInfoBean user_info;

        public String getTicket() {
            return ticket;
        }

        public void setTicket(String ticket) {
            this.ticket = ticket;
        }

        public boolean isLogin_flag() {
            return login_flag;
        }

        public void setLogin_flag(boolean login_flag) {
            this.login_flag = login_flag;
        }

        public UserInfoBean getUser_info() {
            return user_info;
        }

        public void setUser_info(UserInfoBean user_info) {
            this.user_info = user_info;
        }

        public static class UserInfoBean {
            /**
             * id : 64201
             * c_user_id : 76698
             * nickname :
             * status : 1
             * grade_id : 0
             * sex : 1
             * headimg :
             * user_father_id : 0
             * user_grandfather_id : 0
             * invitation_code : T55220
             * birthday :
             * lat : 0
             * lng : 0
             * gold_flag : 0
             * total_gold_flag : 0
             * frozen_gold_flag : 0
             * balance : 0.00
             * total_balance : 0.00
             * frozen_balance : 0.00
             * oredstatus : 0
             * redcash : 0
             * create_time : 1541142136
             * is_cross_read_level : 0
             */

            private String id;
            private String c_user_id;
            private String nickname;
            private String status;
            private String grade_id;
            private String sex;
            private String headimg;
            private String user_father_id;
            private String user_grandfather_id;
            private String invitation_code;
            private String birthday;
            private String lat;
            private String lng;
            private String gold_flag;
            private String total_gold_flag;
            private String frozen_gold_flag;
            private String balance;
            private String total_balance;
            private String frozen_balance;
            private String oredstatus;
            private String redcash;
            private String create_time;
            private String is_cross_read_level;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getC_user_id() {
                return c_user_id;
            }

            public void setC_user_id(String c_user_id) {
                this.c_user_id = c_user_id;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getGrade_id() {
                return grade_id;
            }

            public void setGrade_id(String grade_id) {
                this.grade_id = grade_id;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getHeadimg() {
                return headimg;
            }

            public void setHeadimg(String headimg) {
                this.headimg = headimg;
            }

            public String getUser_father_id() {
                return user_father_id;
            }

            public void setUser_father_id(String user_father_id) {
                this.user_father_id = user_father_id;
            }

            public String getUser_grandfather_id() {
                return user_grandfather_id;
            }

            public void setUser_grandfather_id(String user_grandfather_id) {
                this.user_grandfather_id = user_grandfather_id;
            }

            public String getInvitation_code() {
                return invitation_code;
            }

            public void setInvitation_code(String invitation_code) {
                this.invitation_code = invitation_code;
            }

            public String getBirthday() {
                return birthday;
            }

            public void setBirthday(String birthday) {
                this.birthday = birthday;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLng() {
                return lng;
            }

            public void setLng(String lng) {
                this.lng = lng;
            }

            public String getGold_flag() {
                return gold_flag;
            }

            public void setGold_flag(String gold_flag) {
                this.gold_flag = gold_flag;
            }

            public String getTotal_gold_flag() {
                return total_gold_flag;
            }

            public void setTotal_gold_flag(String total_gold_flag) {
                this.total_gold_flag = total_gold_flag;
            }

            public String getFrozen_gold_flag() {
                return frozen_gold_flag;
            }

            public void setFrozen_gold_flag(String frozen_gold_flag) {
                this.frozen_gold_flag = frozen_gold_flag;
            }

            public String getBalance() {
                return balance;
            }

            public void setBalance(String balance) {
                this.balance = balance;
            }

            public String getTotal_balance() {
                return total_balance;
            }

            public void setTotal_balance(String total_balance) {
                this.total_balance = total_balance;
            }

            public String getFrozen_balance() {
                return frozen_balance;
            }

            public void setFrozen_balance(String frozen_balance) {
                this.frozen_balance = frozen_balance;
            }

            public String getOredstatus() {
                return oredstatus;
            }

            public void setOredstatus(String oredstatus) {
                this.oredstatus = oredstatus;
            }

            public String getRedcash() {
                return redcash;
            }

            public void setRedcash(String redcash) {
                this.redcash = redcash;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getIs_cross_read_level() {
                return is_cross_read_level;
            }

            public void setIs_cross_read_level(String is_cross_read_level) {
                this.is_cross_read_level = is_cross_read_level;
            }
        }
    }
}
