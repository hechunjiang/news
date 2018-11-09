package com.news.mobile.entiyt;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/5 17
 */
public class NewsDetailResponse {


    /**
     * code : 200
     * msg : success
     * data : {"id":"15","title":"Para Penyerang Juragan Gol di Piala AFF 2018","create_time":"2018-11-06 23:56:30","content":"<section ahw='1' class='wrap'><div class='article'><div class='top'><h1>Para Penyerang Juragan Gol di Piala AFF 2018<\/h1><div class='info clearfix'><img class='source-icon' src='' /><div class='view-l'><a href='https://football-tribe.com/indonesia/2018/11/07/juragan-gol-aff/'>Football Tribe<\/a><span>11-07 | 14:56<\/span><\/div><span class='read-count'><\/span><\/div><\/div><div class='content'><p><img data-src=\"http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com/image/20181107/ba/ba20f91172829981e3bef07f1045347d85de3d78.jpg\" data-size=\"640,426\" /> <span><\/span><p> <\/p><\/p> <p>Seri terakhir dari rangkaian \u201c<span>Player to Watch<\/span>\u201d di <span>Piala AFF 2018<\/span> racikan Football Tribe. Setelah <span>kiper<\/span>, <span>bek<\/span>, dan <span>gelandang<\/span> sudah kami sajikan di hari-hari sebelumnya, kini saatnya beralih ke para penyerang juragan gol. <\/p><p>Siapa saja juru gedor yang masuk daftar pilihan kami? Yuk kita intip daftarnya. <\/p> <p><img data-src=\"http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com/image/20181107/9a/9aa6eb7266912cab4465e2255ba3308fc43bf1c6.jpg\" data-size=\"640,426\" /> <span><\/span><p> <\/p><\/p> <p><\/p><span><span>Safawi Rasid (Malaysia)<\/span><\/span> <p>Pemain Terbaik, Gelandang Terbaik, dan Talenta Terbaik Malaysia, semua penghargaan itu direbut oleh Safawi Rasid, penyerang sayap Johor Darul Ta\u2019zim (JDT). Di usia yang masih 21 tahun ia sudah menunjukkan kematangan bermain, dengan mencetak 6 gol dari 21 penampilan di level klub. Posisi terbaiknya adalah penyerang sayap tapi juga bisa ditempatkan sebagai ujung tombak. <\/p><p>Foto: Johor Southern Tigers <\/p> <p><img data-src=\"http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com/image/20181107/e4/e4f7d61969661f07e0942223f6c18c8dcc03b01d.jpg\" data-size=\"640,359\" /> <span><\/span><p> <\/p><\/p> <p><\/p><span><span>Alberto Goncalves (Indonesia)<\/span><\/span> <p>Indonesia kembali mengikuti Piala AFF dengan penyerang naturalisasi. Kali ini Beto Goncalves yang diandalkan di lini depan, seorang predator kotak penalti dengan 100 gol lebih di Liga Indonesia. Meski tak lagi muda, tapi pergerakan Beto masih sangat lincah. Ia sama berbahayanya baik di bola bawah maupun bola atas, yang tentunya sangat melelahkan bagi bek lawan untuk menjaganya. <\/p> <p><img data-src=\"http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com/image/20181107/a3/a33446cbfe7d6107b2f1a0dea354784eb0546ba4.jpg\" data-size=\"640,426\" /> <span><\/span><p> <\/p><\/p> <p><\/p><span><span>Chananan Pombuppha (Thailand)<\/span><\/span> <p>Salah satu sosok kunci di masa-masa awal Kiatisuk Senamuang menangani timnas Thailand. Sebagai penyerang, Chananan yang dua kali memenangkan SEA Games pada 2013 dan 2015, adalah tipikal penyerang oportunis. Ia selalu berusaha mencetak gol di situasi apapun, dengan anggota badan manapun. Menariknya, di beberapa laga terakhir ia lebih sering ditempatkan di pos gelandang serang atau sayap kiri. <\/p><p>Foto: @ThailandNTOFFICIAL <\/p> <p><img data-src=\"http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com/image/20181107/61/61bcfc20dcf1d2606876f7962479c6f68adadecd.jpg\" data-size=\"640,336\" /> <span><\/span><p> <\/p><\/p> <p><\/p><span><span>Nguyen Anh Duc (Vietnam)<\/span><\/span> <p>Pemain tertua di skuat Vietnam saat ini. Anh Duc yang berusia 33 tahun, diharapkan bisa menjadi mentor bagi rekan-rekannya yang masih muda. Dengan segudang pengalamannya, Vietnam akan diuntungkan dengan ketenangan Anh Duc menjaringkan bola. Ia sudah mencetak 200 gol lebih di V.League 1, dan di Piala AFF kali ini bertekad mengawinkan trofi juara dengan gelar top skor. <\/p> <p> <\/p> <\/p> <span> <p> <\/p> <\/span> <p> <\/p><\/p><\/div><\/div><\/section><script ahw='1'>var _config={type:2,canReward:0,sourceName: ['sgsnssdk.com'][0],isOrigin:0,sourceSite:'sgsnssdk.com',sourceUrl:'https://football-tribe.com/indonesia/2018/11/07/juragan-gol-aff/',siteWWW:'',siteName:'',sourceUrl2:'',source_icon:'',copyright:'',authorid:'', nickname:'',avatar:''};<\/script>","visit_count":65,"comment_count":0,"author_name":"Football Tribe","du_type":0,"is_liked":false}
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

    @Entity(tableName = "news")
    public static class DataBean {
        /**
         * id : 15
         * title : Para Penyerang Juragan Gol di Piala AFF 2018
         * create_time : 2018-11-06 23:56:30
         * content : <section ahw='1' class='wrap'><div class='article'><div class='top'><h1>Para Penyerang Juragan Gol di Piala AFF 2018</h1><div class='info clearfix'><img class='source-icon' src='' /><div class='view-l'><a href='https://football-tribe.com/indonesia/2018/11/07/juragan-gol-aff/'>Football Tribe</a><span>11-07 | 14:56</span></div><span class='read-count'></span></div></div><div class='content'><p><img data-src="http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com/image/20181107/ba/ba20f91172829981e3bef07f1045347d85de3d78.jpg" data-size="640,426" /> <span></span><p> </p></p> <p>Seri terakhir dari rangkaian “<span>Player to Watch</span>” di <span>Piala AFF 2018</span> racikan Football Tribe. Setelah <span>kiper</span>, <span>bek</span>, dan <span>gelandang</span> sudah kami sajikan di hari-hari sebelumnya, kini saatnya beralih ke para penyerang juragan gol. </p><p>Siapa saja juru gedor yang masuk daftar pilihan kami? Yuk kita intip daftarnya. </p> <p><img data-src="http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com/image/20181107/9a/9aa6eb7266912cab4465e2255ba3308fc43bf1c6.jpg" data-size="640,426" /> <span></span><p> </p></p> <p></p><span><span>Safawi Rasid (Malaysia)</span></span> <p>Pemain Terbaik, Gelandang Terbaik, dan Talenta Terbaik Malaysia, semua penghargaan itu direbut oleh Safawi Rasid, penyerang sayap Johor Darul Ta’zim (JDT). Di usia yang masih 21 tahun ia sudah menunjukkan kematangan bermain, dengan mencetak 6 gol dari 21 penampilan di level klub. Posisi terbaiknya adalah penyerang sayap tapi juga bisa ditempatkan sebagai ujung tombak. </p><p>Foto: Johor Southern Tigers </p> <p><img data-src="http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com/image/20181107/e4/e4f7d61969661f07e0942223f6c18c8dcc03b01d.jpg" data-size="640,359" /> <span></span><p> </p></p> <p></p><span><span>Alberto Goncalves (Indonesia)</span></span> <p>Indonesia kembali mengikuti Piala AFF dengan penyerang naturalisasi. Kali ini Beto Goncalves yang diandalkan di lini depan, seorang predator kotak penalti dengan 100 gol lebih di Liga Indonesia. Meski tak lagi muda, tapi pergerakan Beto masih sangat lincah. Ia sama berbahayanya baik di bola bawah maupun bola atas, yang tentunya sangat melelahkan bagi bek lawan untuk menjaganya. </p> <p><img data-src="http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com/image/20181107/a3/a33446cbfe7d6107b2f1a0dea354784eb0546ba4.jpg" data-size="640,426" /> <span></span><p> </p></p> <p></p><span><span>Chananan Pombuppha (Thailand)</span></span> <p>Salah satu sosok kunci di masa-masa awal Kiatisuk Senamuang menangani timnas Thailand. Sebagai penyerang, Chananan yang dua kali memenangkan SEA Games pada 2013 dan 2015, adalah tipikal penyerang oportunis. Ia selalu berusaha mencetak gol di situasi apapun, dengan anggota badan manapun. Menariknya, di beberapa laga terakhir ia lebih sering ditempatkan di pos gelandang serang atau sayap kiri. </p><p>Foto: @ThailandNTOFFICIAL </p> <p><img data-src="http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com/image/20181107/61/61bcfc20dcf1d2606876f7962479c6f68adadecd.jpg" data-size="640,336" /> <span></span><p> </p></p> <p></p><span><span>Nguyen Anh Duc (Vietnam)</span></span> <p>Pemain tertua di skuat Vietnam saat ini. Anh Duc yang berusia 33 tahun, diharapkan bisa menjadi mentor bagi rekan-rekannya yang masih muda. Dengan segudang pengalamannya, Vietnam akan diuntungkan dengan ketenangan Anh Duc menjaringkan bola. Ia sudah mencetak 200 gol lebih di V.League 1, dan di Piala AFF kali ini bertekad mengawinkan trofi juara dengan gelar top skor. </p> <p> </p> </p> <span> <p> </p> </span> <p> </p></p></div></div></section><script ahw='1'>var _config={type:2,canReward:0,sourceName: ['sgsnssdk.com'][0],isOrigin:0,sourceSite:'sgsnssdk.com',sourceUrl:'https://football-tribe.com/indonesia/2018/11/07/juragan-gol-aff/',siteWWW:'',siteName:'',sourceUrl2:'',source_icon:'',copyright:'',authorid:'', nickname:'',avatar:''};</script>
         * visit_count : 65
         * comment_count : 0
         * author_name : Football Tribe
         * du_type : 0
         * is_liked : false
         */
        @NonNull
        @PrimaryKey(autoGenerate = false)
        private String id;
        private String title;
        private String create_time;
        private String content;
        private int visit_count;
        private int comment_count;
        private String author_name;
        private int du_type;
        private boolean is_liked;
        private boolean hasGold;

        public boolean isHasGold() {
            return hasGold;
        }

        public void setHasGold(boolean hasGold) {
            this.hasGold = hasGold;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getVisit_count() {
            return visit_count;
        }

        public void setVisit_count(int visit_count) {
            this.visit_count = visit_count;
        }

        public int getComment_count() {
            return comment_count;
        }

        public void setComment_count(int comment_count) {
            this.comment_count = comment_count;
        }

        public String getAuthor_name() {
            return author_name;
        }

        public void setAuthor_name(String author_name) {
            this.author_name = author_name;
        }

        public int getDu_type() {
            return du_type;
        }

        public void setDu_type(int du_type) {
            this.du_type = du_type;
        }

        public boolean isIs_liked() {
            return is_liked;
        }

        public void setIs_liked(boolean is_liked) {
            this.is_liked = is_liked;
        }
    }
}
