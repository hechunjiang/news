package com.news.mobile.entiyt;

import android.os.Parcel;
import android.os.Parcelable;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * Created by sfy. on 2018/11/3 0003.
 */

public class NewsInfoResponse {

    public static final int NEWS_INFO_THREE_IMAGE_TYPE0 = 0;
    public static final int NEWS_INFO_ONE_BIG_IMAGE_TYPE1 = 1;
    public static final int NEWS_INFO_ONE_NORMAL_TYPE2 = 2;


    /**
     * code : 200
     * msg :
     * data : {"data":[{"id":278,"title":"Pemilik Toko Tetap Buka saat Azan, Wakil Bupati Aceh Besar Naik Pitam Sambil Bawa Kayu","href":"http://article.kubiknews.com/detail/2018/11/09/4166042.html?content_id=4166042&key=def5RUlJvqAs8ZtCgbsnKm1jnydRtSzwJiWd4Ot04v9IhWgiR6OoT67fJSvbTgeVKnVs2YQpP3aCV5_UcfS2p6S7vXqxM5L2Q4Fud8_ZIwWj9RZ7hD1WNidNwd6HpMXYGQ&pv_id={05E6478B-EE04-1256-482F-942F72A9D12B}&cid=2&cat=2&rss_source=babe&fr=1&hj=0&o=2&p=1&skip_ad=0","source":"http://news.rakyatku.com/read/126891/2018/11/09/pemilik-toko-tetap-buka-saat-azan-wakil-bupati-aceh-besar-naik-pitam-sambil-bawa-kayu","keywords":null,"desc":"Wakil Bupati Aceh Besar, Husaini A Wahab menegur pemilik toko yang mengabaikan azan. (FOTO: SERAM","user_id":null,"cover_img":["http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/2f/2fe9bc07c128392ad47b6b4f5210b3683e5b071f.jpg"],"cover_show_type":0,"author_avatar":"http://sta.beritaqu.net/image/avatar/default.jpg?x-oss-process=image/resize,m_fill,h_160,w_160","author_name":"Rakyatku","uni":"4166042","language":"in","du_type":0,"create_time":"2018-11-08 20:16:47","update_time":null,"channel":"Kubik","type_id":2,"visit_count":0,"like_count":0,"comment_count":0,"can_comment":1,"unlike_enable":0,"unlike_count":null,"share_count":0,"listorder":0,"status":1,"is_gold":1,"is_redpack":0,"is_ad":0,"open_browser":0,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"","display_type":1,"news_stop_second":15000,"is_liked":false},{"id":277,"title":"Calon Juara, Inilah 7 Tim yang Belum Terkalahkan di Liga-liga Eropa","href":"http://article.kubiknews.com/detail/2018/11/09/4166312.html?content_id=4166312&key=179bJeave2xO0psCDN-3Ldw4l0-aH_N5qEjwzJ3LlmkE2COTnpbzwzrRq9IifH8RYEo0hEj4KvambB3lzntj14B0r26ZCkKJz9mrpvvINY21pnjWs296pv8m-niWAkBUhw&pv_id={05E6478B-EE04-1256-482F-942F72A9D12B}&cid=2&cat=2&rss_source=IDNTimes&fr=1&hj=0&o=2&p=1&skip_ad=0","source":"https://www.idntimes.com/sport/soccer/ganjar-firmansyah/tim-yang-belum-terkalahkan-di-liga-liga-eropa-c1c2","keywords":null,"desc":"Liga-liga Eropa selalu menjadi kiblat sepak bola dunia. Tak hanya diisi oleh deretan pemain hebat d","user_id":null,"cover_img":["http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/53/53f6c0949c6e7106352b4a10e616ee4311cd340c.jpg","http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/45/453e2caaf0f3f10f8a6b6c7b470781bdb65a5c0e.jpg","http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/41/414e256e9ceb53f0f7122680bfc8556ccede63fa.jpg"],"cover_show_type":0,"author_avatar":"http://sta.beritaqu.net/image/avatar/default.jpg?x-oss-process=image/resize,m_fill,h_160,w_160","author_name":"IDNTimes","uni":"4166312","language":"in","du_type":0,"create_time":"2018-11-08 20:16:47","update_time":null,"channel":"Kubik","type_id":2,"visit_count":1,"like_count":0,"comment_count":0,"can_comment":1,"unlike_enable":0,"unlike_count":null,"share_count":0,"listorder":0,"status":1,"is_gold":1,"is_redpack":0,"is_ad":0,"open_browser":0,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"","display_type":1,"news_stop_second":15000,"is_liked":false},{"id":276,"title":"Kisah Mendebarkan saat Pesawat Garuda Indonesia GA421 Lakukan Pendaratan Darurat di Atas Sungai Bengawan Solo","href":"http://article.kubiknews.com/detail/2018/11/09/4166149.html?content_id=4166149&key=80e68usluQBXWeaaHlhtxrb8LOaXcGLjFl3gRHK73NjVVWaDsedz4eVyrhM-AE3tZn5p6kmR3Jcuup0-piaRTwAS8A0B6T9c8ezUYxaadqCxDvV6uCmFOLD-mWuiqFvxXQ&pv_id={AD9A7E5C-A898-BA1C-504B-B7550218DFEF}&cid=2&cat=2&rss_source=Stringisari&fr=1&hj=0&o=2&p=1&skip_ad=0","source":"http://Stringisari.grid.id/read/03994525/kisah-mendebarkan-saat-pesawat-garuda-indonesia-ga421-lakukan-pendaratan-darurat-di-atas-sungai-bengawan-solo","keywords":null,"desc":"Pesawat Garuda Indonesia.     Stringisari-Online.com \u2013 Lion Air menjadi pembicaraan di Indonesia da","user_id":null,"cover_img":["http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/f7/f70084df8c0e9ea444e623f7d11a2b2275f0c842.jpg"],"cover_show_type":0,"author_avatar":"http://sta.beritaqu.net/image/avatar/default.jpg?x-oss-process=image/resize,m_fill,h_160,w_160","author_name":"Stringisari","uni":"4166149","language":"in","du_type":0,"create_time":"2018-11-08 20:12:34","update_time":null,"channel":"Kubik","type_id":2,"visit_count":1,"like_count":0,"comment_count":0,"can_comment":1,"unlike_enable":0,"unlike_count":null,"share_count":0,"listorder":0,"status":1,"is_gold":1,"is_redpack":0,"is_ad":0,"open_browser":0,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"","display_type":1,"news_stop_second":15000,"is_liked":false},{"id":0,"title":1,"href":2,"source":3,"keywords":4,"desc":5,"user_id":6,"cover_img":7,"cover_show_type":8,"author_avatar":9,"author_name":10,"uni":11,"language":12,"du_type":13,"create_time":14,"update_time":15,"channel":16,"type_id":17,"visit_count":18,"like_count":19,"comment_count":20,"can_comment":21,"unlike_enable":22,"unlike_count":23,"share_count":24,"listorder":25,"status":26,"is_gold":27,"is_redpack":28,"is_ad":1,"open_browser":30,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"101","display_type":33,"news_stop_second":34,"is_liked":false},{"id":275,"title":"5 Seleb Indonesia ini Punya Ibu Sambung yang Usianya Tak Terpaut Jauh. Kaya Kakak Beradik","href":"http://article.kubiknews.com/detail/2018/11/09/4166305.html?content_id=4166305&key=bc2chmbhdPk08C5Rj_SBTt5HIrUuBVQ7vb6RcN-zEE5HMVXQJdPDGUx-LXPrO2B0WgiY23brW8mWjJ1IIOmddBQEQY3TEBwDeW_HACMgrJqElbgd-SAcTjRWV4obCFamaA&pv_id={AD9A7E5C-A898-BA1C-504B-B7550218DFEF}&cid=2&cat=2&rss_source=cewekbanget&fr=1&hj=0&o=2&p=1&skip_ad=0","source":"http://cewekbanget.grid.id/read/06994569/5-seleb-indonesia-ini-punya-ibu-sambung-yang-usianya-tak-terpaut-jauh-kaya-kakak-beradik","keywords":null,"desc":"Kolase Cewekbanget.id     Cewekbanget.id \u2013 Dalam sebuah drama atau cerita dongeng, peran ibu sambu","user_id":null,"cover_img":["http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/18/1812bc5de1b363534d2f90c8909bb5036c109282.jpg","http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/d7/d72181dfd36773093ae22716b06e236405a6aa5b.jpg","http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/05/051e66bdbfd81045fe86b1e8c567db9aab42a6e6.jpg"],"cover_show_type":0,"author_avatar":"http://sta.beritaqu.net/image/avatar/default.jpg?x-oss-process=image/resize,m_fill,h_160,w_160","author_name":"cewekbanget","uni":"4166305","language":"in","du_type":0,"create_time":"2018-11-08 20:12:34","update_time":null,"channel":"Kubik","type_id":2,"visit_count":1,"like_count":0,"comment_count":0,"can_comment":1,"unlike_enable":0,"unlike_count":null,"share_count":0,"listorder":0,"status":1,"is_gold":1,"is_redpack":0,"is_ad":0,"open_browser":0,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"","display_type":1,"news_stop_second":15000,"is_liked":false},{"id":274,"title":"Bawa Golok dan Membabi Buta, Seorang Warga Serang Polsek Penjaringan","href":"http://article.kubiknews.com/detail/2018/11/09/4166318.html?content_id=4166318&key=541ffT75hEnWtJhZ_wWhfk8m4JQpo2mJwRuVsPgo4JPqjui6qRNaITsdNtZ9HsEFkGjvS5C4-N3RlOEKI30N4pfl4d4UA2aBwxnzY1X7SR6czdOvS2wB30H7mqqFoxIOVA&pv_id={AD9A7E5C-A898-BA1C-504B-B7550218DFEF}&cid=2&cat=2&rss_source=covesia&fr=1&hj=0&o=2&p=1&skip_ad=0","source":"https://covesia.com/news/baca/63485/bawa-golok-dan-membabi-buta-seorang-warga-serang-polsek-penjaringan","keywords":null,"desc":"Penyerang Polsek Penjaringan. Foto: detikcom/ istimewa  Covesia.com - Seorang pria bernama Rohandi","user_id":null,"cover_img":["http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/b9/b92c241fd13bee278aca3f45f767b9ab69fa295c.jpg"],"cover_show_type":0,"author_avatar":"http://sta.beritaqu.net/image/avatar/default.jpg?x-oss-process=image/resize,m_fill,h_160,w_160","author_name":"covesia","uni":"4166318","language":"in","du_type":0,"create_time":"2018-11-08 20:12:34","update_time":null,"channel":"Kubik","type_id":2,"visit_count":0,"like_count":0,"comment_count":0,"can_comment":1,"unlike_enable":0,"unlike_count":null,"share_count":0,"listorder":0,"status":1,"is_gold":1,"is_redpack":0,"is_ad":0,"open_browser":0,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"","display_type":1,"news_stop_second":15000,"is_liked":false},{"id":273,"title":"Pelaku Mabuk Air Rebusan Pembalut Susah Dijerat Hukum Karena Pembalut Bukan Termasuk Narkoba","href":"http://article.kubiknews.com/detail/2018/11/09/4164656.html?content_id=4164656&key=0359SRtLTV2BSBErEj_1GtykIzppo9WVgFl6GwEMwwN4Kv_tyx-3oEeqHMdiECVbYYaBiG9jGO_r3QZCYjJPazcCryURf0In0qhpwMKsjablX3rgW8enE8eeo3IPIy_ZyQ&pv_id={CF9EC17E-F351-1B41-7C4D-09B2620ADCE3}&cid=2&cat=2&rss_source=mojok&fr=1&hj=0&o=2&p=1&skip_ad=0","source":"https://mojok.co/red/rame/kilas/pelaku-mabuk-air-rebusan-pembalut-susah-dijerat-hukum-karena-pembalut-bukan-termasuk-narkoba/","keywords":null,"desc":"Salah satu humor lawas paling legendaris tentang penggunaan pembalut sebagai sebuah konsumsi adalah","user_id":null,"cover_img":["http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/29/29ef29b987c2830017f9cf4e4699a5029cf63840.jpg"],"cover_show_type":0,"author_avatar":"http://sta.beritaqu.net/image/avatar/default.jpg?x-oss-process=image/resize,m_fill,h_160,w_160","author_name":"mojok","uni":"4164656","language":"in","du_type":0,"create_time":"2018-11-08 20:09:04","update_time":null,"channel":"Kubik","type_id":2,"visit_count":56,"like_count":1,"comment_count":0,"can_comment":1,"unlike_enable":0,"unlike_count":null,"share_count":5,"listorder":0,"status":1,"is_gold":1,"is_redpack":0,"is_ad":0,"open_browser":0,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"","display_type":1,"news_stop_second":15000,"is_liked":false},{"id":0,"title":1,"href":2,"source":3,"keywords":4,"desc":5,"user_id":6,"cover_img":7,"cover_show_type":8,"author_avatar":9,"author_name":10,"uni":11,"language":12,"du_type":13,"create_time":14,"update_time":15,"channel":16,"type_id":17,"visit_count":18,"like_count":19,"comment_count":20,"can_comment":21,"unlike_enable":22,"unlike_count":23,"share_count":24,"listorder":25,"status":26,"is_gold":27,"is_redpack":28,"is_ad":1,"open_browser":30,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"101","display_type":33,"news_stop_second":34,"is_liked":false},{"id":271,"title":"Mayangsari Sempat Ketahuan Merokok, Ini Penampilannya Saat Arisan Bersama Para Seleb","href":"http://article.kubiknews.com/detail/2018/11/09/4165940.html?content_id=4165940&key=ab713YvbQx4HooqCZ787sM9ASZ296ZGFkXezsTOqVsS6C0J7UX-qqmNaAkk3TU-GaXnZ3_WbJqDEGL25UohE_7iALFmissphJI2Fee_k-ERnObH18bn2gjlBt81a1MB84Q&pv_id={4107881B-7EB3-24B4-C0E1-414B013F6446}&cid=2&cat=2&rss_source=nakita&fr=1&hj=0&o=2&p=1&skip_ad=0","source":"http://nakita.grid.id/read/02994582/mayangsari-sempat-ketahuan-merokok-ini-penampilannya-saat-arisan-bersama-para-seleb","keywords":null,"desc":"Instagram/mayangsaritrihatmodjoreal  Mayangsari bersama suami dan anaknya   Sosok artis senior  mu","user_id":null,"cover_img":["http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/3a/3af435b5d6f04c490011e1e962cea9a5aefa6ed8.jpg","http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/3f/3f04453ebf038b4637dcce55a4f385e9ffec3bed.jpg","http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/fa/fa95ce6b443c30dbab05d80fa65855a8bf119143.jpg"],"cover_show_type":0,"author_avatar":"http://sta.beritaqu.net/image/avatar/default.jpg?x-oss-process=image/resize,m_fill,h_160,w_160","author_name":"nakita","uni":"4165940","language":"in","du_type":0,"create_time":"2018-11-08 20:00:06","update_time":null,"channel":"Kubik","type_id":2,"visit_count":0,"like_count":0,"comment_count":0,"can_comment":1,"unlike_enable":0,"unlike_count":null,"share_count":0,"listorder":0,"status":1,"is_gold":1,"is_redpack":0,"is_ad":0,"open_browser":0,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"","display_type":1,"news_stop_second":15000,"is_liked":false},{"id":270,"title":"Viral, Video Anak SD di Sukabumi Merokok di Sekolah, Begini Faktanya !","href":"http://article.kubiknews.com/detail/2018/11/09/4165943.html?content_id=4165943&key=0222T59PASUmzk1IBa06mvbSpfUone09yH9s13Hu16yw5uA2wOj27bcU2kaY3sQlN9Cd8n4XWy6L47p2OdIexR9G4mHJz1GKkV6ZSo3jQQlwV3GKvIxptK8i6Z6NlgREmQ&pv_id={4107881B-7EB3-24B4-C0E1-414B013F6446}&cid=2&cat=2&rss_source=Indowarta&fr=1&hj=0&o=2&p=1&skip_ad=0","source":"https://indowarta.com/72858/viral-video-anak-sd-di-sukabumi-merokok-di-sekolah-begini-faktanya/","keywords":null,"desc":"Copyright©detik Video Anak SD di Sukabumi Merokok di Sekolah Jadi Sorotan Publik ! Indowarta.com \u2013 B","user_id":null,"cover_img":["http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/5a/5a832526cade27f830ccdaf4f3f597ff25c9ca50.jpg"],"cover_show_type":0,"author_avatar":"http://sta.beritaqu.net/image/avatar/default.jpg?x-oss-process=image/resize,m_fill,h_160,w_160","author_name":"Indowarta","uni":"4165943","language":"in","du_type":0,"create_time":"2018-11-08 20:00:06","update_time":null,"channel":"Kubik","type_id":2,"visit_count":0,"like_count":0,"comment_count":0,"can_comment":1,"unlike_enable":0,"unlike_count":null,"share_count":0,"listorder":0,"status":1,"is_gold":1,"is_redpack":0,"is_ad":0,"open_browser":0,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"","display_type":1,"news_stop_second":15000,"is_liked":false},{"id":269,"title":"Pelaku Sempat Teriakkan Takbir saat Serang Polsek Penjaringan","href":"http://article.kubiknews.com/detail/2018/11/09/4165858.html?content_id=4165858&key=8ec73QhsSrG4WJ4s0koYOh5-YoWdyELj_Qj446VNgEjp-o-wQa8fQT_Qug2h_0suexKa1lP_44bWTRfpGrUJ9MMnk_iPfPHA6o4vz27vq77XixU7XdahzyHFtYn9eLimSQ&pv_id={94FF9D42-D3E7-9626-3460-A9C6520C6596}&cid=2&cat=2&rss_source=Okezone&fr=1&hj=0&o=2&p=1&skip_ad=0","source":"https://news.okezone.com/read/2018/11/09/338/1975395/pelaku-sempat-teriakkan-takbir-saat-serang-polsek-penjaringan","keywords":null,"desc":"Kaca di salah satu ruangan mapolsek Metro Penjaringan pecah akibat diserang seorang pria. (Ist)","user_id":null,"cover_img":["http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/ae/aea6464c82fc9e0e0782897614ff5a65ab1d7a49.jpg"],"cover_show_type":0,"author_avatar":"http://sta.beritaqu.net/image/avatar/default.jpg?x-oss-process=image/resize,m_fill,h_160,w_160","author_name":"Okezone","uni":"4165858","language":"in","du_type":0,"create_time":"2018-11-08 19:55:59","update_time":null,"channel":"Kubik","type_id":2,"visit_count":0,"like_count":0,"comment_count":0,"can_comment":1,"unlike_enable":0,"unlike_count":null,"share_count":0,"listorder":0,"status":1,"is_gold":0,"is_redpack":0,"is_ad":0,"open_browser":0,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"","display_type":1,"news_stop_second":15000,"is_liked":false},{"id":268,"title":"Polsek Penjaringan Diserang Pria Misterius, 1 Polisi Terluka","href":"http://article.kubiknews.com/detail/2018/11/09/4165859.html?content_id=4165859&key=dfffnzuVlWmssEPFI-L_3ymA_mcNz_3AeFbk_zrTfun7KgYuyp3sSrSbfS_ScS1wgPI9u0imLc1KM19SVx7YW6KnYFaNMsYOYQrZ_av30-1iAgiB04DE0JqOj97ffaSAog&pv_id={94FF9D42-D3E7-9626-3460-A9C6520C6596}&cid=2&cat=2&rss_source=Okezone&fr=1&hj=0&o=2&p=1&skip_ad=0","source":"https://news.okezone.com/read/2018/11/09/338/1975392/polsek-penjaringan-diserang-pria-misterius-1-polisi-terluka","keywords":null,"desc":"Karo Penmas Divisi Humas Polri, Brigjen Dedi Prasetyo. (Foto : Puteranegara Batubara/Okezone)  JAK","user_id":null,"cover_img":["http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/d7/d7f79bcd66a52df9b6a069a9ef48cc6db735e583.jpg"],"cover_show_type":0,"author_avatar":"http://sta.beritaqu.net/image/avatar/default.jpg?x-oss-process=image/resize,m_fill,h_160,w_160","author_name":"Okezone","uni":"4165859","language":"in","du_type":0,"create_time":"2018-11-08 19:55:59","update_time":null,"channel":"Kubik","type_id":2,"visit_count":1,"like_count":0,"comment_count":0,"can_comment":1,"unlike_enable":0,"unlike_count":null,"share_count":0,"listorder":0,"status":1,"is_gold":0,"is_redpack":0,"is_ad":0,"open_browser":0,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"","display_type":1,"news_stop_second":15000,"is_liked":false},{"id":0,"title":1,"href":2,"source":3,"keywords":4,"desc":5,"user_id":6,"cover_img":7,"cover_show_type":8,"author_avatar":9,"author_name":10,"uni":11,"language":12,"du_type":13,"create_time":14,"update_time":15,"channel":16,"type_id":17,"visit_count":18,"like_count":19,"comment_count":20,"can_comment":21,"unlike_enable":22,"unlike_count":23,"share_count":24,"listorder":25,"status":26,"is_gold":27,"is_redpack":28,"is_ad":1,"open_browser":30,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"102","display_type":33,"news_stop_second":34,"is_liked":false},{"id":267,"title":"Jennifer Bachdim Tampil Mempesona di Victoria's Secret Fashion Show 2018, Irfan Bachdim Bangga!","href":"http://article.kubiknews.com/detail/2018/11/09/4165488.html?content_id=4165488&key=83b0fQcX9td4EoDsKhzfQAWuIrSQSHCxcMtT5gEBOhF4dJsw0g2HX-tvF2hYV6QZFtFQXFo9o3u96t0Re2R-NN4yXxiJgj8RJ6_lISNx-ja5XZbo15fhl6Gz4Sz0cKYOfw&pv_id={944F8132-CE2E-622D-182E-3C9829F595D8}&cid=2&cat=2&rss_source=grid+ID&fr=1&hj=0&o=2&p=1&skip_ad=0","source":"http://www.grid.id/read/04994588/jennifer-bachdim-tampil-mempesona-di-victorias-secret-fashion-show-2018-irfan-bachdim-bangga","keywords":null,"desc":"Laporan Wartawan Grid.ID, Dwi Ayu Lestari Grid.ID - Jennifer Bachdim tak menyia-nyiakan kesempat","user_id":null,"cover_img":["http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/f7/f7fbb8ebc303420920779ec429dd866a6a20ef0a.jpg","http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/d4/d4d14cdfab8ae9f786b602f60cdb312ab589a167.jpg","http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/f4/f4376b1507684bf25532c4032a06f1b9a3241b3a.jpg"],"cover_show_type":0,"author_avatar":"http://sta.beritaqu.net/image/avatar/default.jpg?x-oss-process=image/resize,m_fill,h_160,w_160","author_name":"grid ID","uni":"4165488","language":"in","du_type":0,"create_time":"2018-11-08 19:51:46","update_time":null,"channel":"Kubik","type_id":2,"visit_count":5,"like_count":0,"comment_count":0,"can_comment":1,"unlike_enable":0,"unlike_count":null,"share_count":1,"listorder":0,"status":1,"is_gold":0,"is_redpack":0,"is_ad":0,"open_browser":0,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"","display_type":1,"news_stop_second":15000,"is_liked":false},{"id":266,"title":"Piala AFF 2018 - Pelatih Singapura Iri dengan Kemampuan Pemain Timnas Indonesia","href":"http://article.kubiknews.com/detail/2018/11/09/4165711.html?content_id=4165711&key=2ea7wVuyZhl2_0YsHaq5xM1cRnjN2pQhrRnyPBoqnrxcDsHOCa_XMNHzhLM5DwYVbYqlR_Jp5rrMuyp-7s2hPXMGxZZWCheCIFSrPh7JXFIIQlXwYgcQ9zsCfHW6SvqtXw&pv_id={944F8132-CE2E-622D-182E-3C9829F595D8}&cid=2&cat=2&rss_source=bolasport&fr=1&hj=0&o=2&p=1&skip_ad=0","source":"https://www.bolasport.com/timnas/316589-piala-aff-2018--pelatih-singapura-iri-dengan-kemampuan-pemain-timnas-indonesia","keywords":null,"desc":"MUHAMMAD BAGAS/BOLA      BOLASPORT.COM - Pelatih timnas Singapura Fandi Ahmad mengutarakan ras","user_id":null,"cover_img":["http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/df/df8e93a76e01ca3452bce5aaaf8113eeb8cc94b6.jpg"],"cover_show_type":0,"author_avatar":"http://sta.beritaqu.net/image/avatar/default.jpg?x-oss-process=image/resize,m_fill,h_160,w_160","author_name":"bolasport","uni":"4165711","language":"in","du_type":0,"create_time":"2018-11-08 19:51:46","update_time":null,"channel":"Kubik","type_id":2,"visit_count":28,"like_count":1,"comment_count":0,"can_comment":1,"unlike_enable":0,"unlike_count":null,"share_count":2,"listorder":0,"status":1,"is_gold":0,"is_redpack":0,"is_ad":0,"open_browser":0,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"","display_type":1,"news_stop_second":15000,"is_liked":false},{"id":0,"title":1,"href":2,"source":3,"keywords":4,"desc":5,"user_id":6,"cover_img":7,"cover_show_type":8,"author_avatar":9,"author_name":10,"uni":11,"language":12,"du_type":13,"create_time":14,"update_time":15,"channel":16,"type_id":17,"visit_count":18,"like_count":19,"comment_count":20,"can_comment":21,"unlike_enable":22,"unlike_count":23,"share_count":24,"listorder":25,"status":26,"is_gold":27,"is_redpack":28,"is_ad":1,"open_browser":30,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"102","display_type":33,"news_stop_second":34,"is_liked":false},{"id":265,"title":"Potret Jennifer Bachdim Bersama Kendall Jenner dan Model Victoria's Secret Angels Lainnya, Beruntungnya!","href":"http://article.kubiknews.com/detail/2018/11/09/4165870.html?content_id=4165870&key=9eceNfpCytKc4HGKS7weep0-K6L-Nm8OeUm9GgtE5J5ncuZg3FK48qU4SE54wVqG_wCjyAVCt6I80v0_S5it4aoLY-7mCI-GI67JCuZS_6YO6bZs6Gq9q-14eP9mH59O3w&pv_id={944F8132-CE2E-622D-182E-3C9829F595D8}&cid=2&cat=2&rss_source=grid+ID&fr=1&hj=0&o=2&p=1&skip_ad=0","source":"http://www.grid.id/read/04994620/potret-jennifer-bachdim-bersama-kendall-jenner-dan-model-victorias-secret-angels-lainnya-beruntungnya","keywords":null,"desc":"Laporan Wartawan Grid.ID, Dwi Ayu Lestari Grid.ID - Jennifer Bachdim tampaknya jadi sport enthus","user_id":null,"cover_img":["http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/3d/3d65cea88b838f0f2e103876525a7cb4470697a8.jpg","http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/38/38559f479d600a21c694b20d658aa136e5307138.jpg","http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/40/40077260747ee7b5f7462242fea941fec547df71.jpg"],"cover_show_type":0,"author_avatar":"http://sta.beritaqu.net/image/avatar/default.jpg?x-oss-process=image/resize,m_fill,h_160,w_160","author_name":"grid ID","uni":"4165870","language":"in","du_type":0,"create_time":"2018-11-08 19:51:46","update_time":null,"channel":"Kubik","type_id":2,"visit_count":0,"like_count":0,"comment_count":0,"can_comment":1,"unlike_enable":0,"unlike_count":null,"share_count":0,"listorder":0,"status":1,"is_gold":0,"is_redpack":0,"is_ad":0,"open_browser":0,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"","display_type":1,"news_stop_second":15000,"is_liked":false},{"id":264,"title":"Pencarian Hari Ke 11, Basarnas Temukan 8 Potongan Tubuh","href":"http://article.kubiknews.com/detail/2018/11/09/4164132.html?content_id=4164132&key=45c46OvCda2NIZAsW2y2YjAxSbzmm5yu24CYPg07Gem7re5vwoP0LI8El_JynbrDjRt1ofVcO9cC6FZ4w3X2pP4rAlL0EyaPMe93BfTbpH-58w4kOslNVOGXdTFA4h3XVA&pv_id={B2FC9E7C-1883-6947-573D-4BB08A410714}&cid=2&cat=2&rss_source=grid+ID&fr=1&hj=0&o=2&p=1&skip_ad=0","source":"http://www.grid.id/read/04994512/pencarian-hari-ke-11-basarnas-temukan-8-potongan-tubuh","keywords":null,"desc":"Laporan Wartawan Grid.ID - Lalu Hendri Bagus Grid.ID - Tim SAR gabungan terus berupaya mencari k","user_id":null,"cover_img":["http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/fa/fa5e31e5704a69b6e4a1b5663ad01f88d35a790d.jpg"],"cover_show_type":0,"author_avatar":"http://sta.beritaqu.net/image/avatar/default.jpg?x-oss-process=image/resize,m_fill,h_160,w_160","author_name":"grid ID","uni":"4164132","language":"in","du_type":0,"create_time":"2018-11-08 19:47:44","update_time":null,"channel":"Kubik","type_id":2,"visit_count":17,"like_count":2,"comment_count":0,"can_comment":1,"unlike_enable":0,"unlike_count":null,"share_count":0,"listorder":0,"status":1,"is_gold":0,"is_redpack":0,"is_ad":0,"open_browser":0,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"","display_type":1,"news_stop_second":15000,"is_liked":false},{"id":263,"title":"Gagal capai target, karyawan disuruh minum air kencing dan makan kecoa","href":"http://article.kubiknews.com/detail/2018/11/09/4165295.html?content_id=4165295&key=f94esise2LogKmykkwqOhknCJp6dqoPuvLpY3zSwEN7WBovLZ5WGyfiQsh9S_WDTaX1ghlOvCqt3vzn4oOuSJh_H_hAJMZe101BWc9LGZuINMBfVepqck61VbswUMajoeQ&pv_id={B2FC9E7C-1883-6947-573D-4BB08A410714}&cid=2&cat=2&rss_source=batok&fr=1&hj=0&o=2&p=1&skip_ad=0","source":"https://www.batok.co/2018/11/09/gagal-capai-target-karyawan-disuruh-minum-air-kencing-dan-makan-kecoa/","keywords":null,"desc":"Foto: WeiboSebuah perusahaan perlengkapan rumah di Zunyi, Guizhou, China terekam kamera menghukum de","user_id":null,"cover_img":["http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/a5/a5409d636163507abc8067f15ce4e7e02075fe25.jpg"],"cover_show_type":0,"author_avatar":"http://sta.beritaqu.net/image/avatar/default.jpg?x-oss-process=image/resize,m_fill,h_160,w_160","author_name":"batok","uni":"4165295","language":"in","du_type":0,"create_time":"2018-11-08 19:47:44","update_time":null,"channel":"Kubik","type_id":2,"visit_count":13,"like_count":1,"comment_count":0,"can_comment":1,"unlike_enable":0,"unlike_count":null,"share_count":0,"listorder":0,"status":1,"is_gold":0,"is_redpack":0,"is_ad":0,"open_browser":0,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"","display_type":1,"news_stop_second":15000,"is_liked":false},{"id":262,"title":"Atiqah Hasiholan Sebut Ratna Sarumpaet Depresi, Kuasa Hukum MStringa Perlakuan Khusus","href":"http://article.kubiknews.com/detail/2018/11/09/4165328.html?content_id=4165328&key=960elrOyrzoX2SD02jvEHHijIVpd9EA9zzlbbjMKnCSggv2Dbky6CyvDD3mQWuwEsU1pSt0vJ6-VZ2KkwI08Rtn_3Wek_mJvAe86lKGhPZEZctSMvR9oZt1c6hOWTCR3qA&pv_id={A9327FEC-6F92-75EB-07AC-A54C8015C616}&cid=2&cat=2&rss_source=malangtoday&fr=1&hj=0&o=2&p=1&skip_ad=0","source":"https://malangtoday.net/inspirasi/hiburan/atiqah-hasiholan-ratna-sarumpaet-depresi/","keywords":null,"desc":"Selebriti sekaligus putri dari aktivis dan politikus Ratna Sarumpaet, Atiqah Hasiholan akhirnya buka","user_id":null,"cover_img":["http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/5b/5bc92b19ec223e954f4a57f1c231c3ef8701417d.jpg"],"cover_show_type":0,"author_avatar":"http://sta.beritaqu.net/image/avatar/default.jpg?x-oss-process=image/resize,m_fill,h_160,w_160","author_name":"malangtoday","uni":"4165328","language":"in","du_type":0,"create_time":"2018-11-08 19:47:38","update_time":null,"channel":"Kubik","type_id":2,"visit_count":9,"like_count":0,"comment_count":0,"can_comment":1,"unlike_enable":0,"unlike_count":null,"share_count":0,"listorder":0,"status":1,"is_gold":0,"is_redpack":0,"is_ad":0,"open_browser":0,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"","display_type":1,"news_stop_second":15000,"is_liked":false},{"id":261,"title":"Asal Usul Cincin Kawin Dipakai di Jari Manis Tangan Kiri","href":"http://article.kubiknews.com/detail/2018/11/09/4165472.html?content_id=4165472&key=4b85rVBkI9rvUAAJlmjopuXhd5bIXjM4F10cC0mMlBU9Eh5HRalB8FfM3gZE8APWVX240U_6TbFpwb4igJ_IWLrOm9dfuSI-pMnDhjQoIBEgZBpvx3sd3oGXEEKxFn_Qdw&pv_id={A9327FEC-6F92-75EB-07AC-A54C8015C616}&cid=2&cat=2&rss_source=babe&fr=1&hj=0&o=2&p=1&skip_ad=0","source":"https://www.hetanews.com/article/142533/asal-usul-cincin-kawin-dipakai-di-jari-manis-tangan-kiri","keywords":null,"desc":"Eropa, hetanews.com - Selama bertahun-tahun, hampir semua pasangan selalu memakai cincin kawin pa","user_id":null,"cover_img":["http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/22/2262ce4851a141079cbc3f52f277c6f005ed5d43.jpg"],"cover_show_type":0,"author_avatar":"http://sta.beritaqu.net/image/avatar/default.jpg?x-oss-process=image/resize,m_fill,h_160,w_160","author_name":"Hetanews","uni":"4165472","language":"in","du_type":0,"create_time":"2018-11-08 19:47:38","update_time":null,"channel":"Kubik","type_id":2,"visit_count":0,"like_count":0,"comment_count":0,"can_comment":1,"unlike_enable":0,"unlike_count":null,"share_count":0,"listorder":0,"status":1,"is_gold":0,"is_redpack":0,"is_ad":0,"open_browser":0,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"","display_type":1,"news_stop_second":15000,"is_liked":false},{"id":0,"title":1,"href":2,"source":3,"keywords":4,"desc":5,"user_id":6,"cover_img":7,"cover_show_type":8,"author_avatar":9,"author_name":10,"uni":11,"language":12,"du_type":13,"create_time":14,"update_time":15,"channel":16,"type_id":17,"visit_count":18,"like_count":19,"comment_count":20,"can_comment":21,"unlike_enable":22,"unlike_count":23,"share_count":24,"listorder":25,"status":26,"is_gold":27,"is_redpack":28,"is_ad":1,"open_browser":30,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"101","display_type":33,"news_stop_second":34,"is_liked":false},{"id":259,"title":"Cuek Mayangsari Ngerokok Dekat Momo yang Hamil, Geng Artis Kepompong Dibully Dukung Pelakor","href":"http://article.kubiknews.com/detail/2018/11/09/4165836.html?content_id=4165836&key=7f76IJuhAw_dAjXupQ9QdRJE4OB5gBj9gxofSHmOyXimr1-NiJIHka9A-sa48DpT5_tT2XNfNvkQMHFSbRV3GXB4mGewfMv74CR-FJ85_B8PdqH7KN-vxH6LWEnR4ukZOQ&pv_id={A9327FEC-6F92-75EB-07AC-A54C8015C616}&cid=2&cat=2&rss_source=wowkeren&fr=1&hj=0&o=2&p=1&skip_ad=0","source":"https://www.wowkeren.com/berita/tampil/00231507.html","keywords":null,"desc":"Geng Iis Dahlia, Melly Goeslaw, Rossa dkk dinilai kalah dari squad Nia Ramadhani cs yang mendepak me","user_id":null,"cover_img":["http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/d7/d755e5ce80fa44d4f043e513814f2df4beeba359.jpg"],"cover_show_type":0,"author_avatar":"http://sta.beritaqu.net/image/avatar/default.jpg?x-oss-process=image/resize,m_fill,h_160,w_160","author_name":"wowkeren","uni":"4165836","language":"in","du_type":0,"create_time":"2018-11-08 19:47:38","update_time":null,"channel":"Kubik","type_id":2,"visit_count":0,"like_count":0,"comment_count":0,"can_comment":1,"unlike_enable":0,"unlike_count":null,"share_count":0,"listorder":0,"status":1,"is_gold":0,"is_redpack":0,"is_ad":0,"open_browser":0,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"","display_type":1,"news_stop_second":15000,"is_liked":false},{"id":258,"title":"Pelaku Penyerang Polsek Penjaringan Depresi dan Ingin Mati Ditembak Polisi","href":"http://article.kubiknews.com/detail/2018/11/09/4165253.html?content_id=4165253&key=aff6AD3ZG1Wq-6qpBOP7wzB4BIyfoYsTclQGhF6EFvQ8FWTv42ddvfSMTDX_HHa1MXQ9wmc6Ctsss_gQGCoCJjSSft2j_x4uHm7fysDbssbiGQRxyW3ohtcIO--p7LgMOA&pv_id={15C49ABE-7C9F-DF6D-41B4-9BD38A2D21CC}&cid=2&cat=2&rss_source=babe&fr=1&hj=0&o=2&p=1&skip_ad=0","source":"http://poskotanews.com/2018/11/09/pelaku-penyerang-polsek-penjaringan-depresi-dan-ingin-mati-ditembak-polisi/","keywords":null,"desc":"JAKARTA \u2013 Luka tembak di pangkal lengan, mengakhiri aksi brutal Rohandi (31),  pria yang menyeran","user_id":null,"cover_img":["http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/ad/adf0a9322fc7f6ad0014d10f2507961d334517e3.jpg"],"cover_show_type":0,"author_avatar":"http://sta.beritaqu.net/image/avatar/default.jpg?x-oss-process=image/resize,m_fill,h_160,w_160","author_name":"Poskotanews","uni":"4165253","language":"in","du_type":0,"create_time":"2018-11-08 19:39:18","update_time":null,"channel":"Kubik","type_id":2,"visit_count":0,"like_count":0,"comment_count":0,"can_comment":1,"unlike_enable":0,"unlike_count":null,"share_count":0,"listorder":0,"status":1,"is_gold":0,"is_redpack":0,"is_ad":0,"open_browser":0,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"","display_type":1,"news_stop_second":15000,"is_liked":false},{"id":257,"title":"Kronologis Penyerangan Polsek Penjaringan, Bermula dari Parkir Motor","href":"http://article.kubiknews.com/detail/2018/11/09/4165518.html?content_id=4165518&key=dda294PIlzjNgyRjyoTxuRu3TBqmnUho1aH3yeN26dSQh4wLeDiTjpfEhHUUX67c52c5tKLjdoA7d2BzpPN6jAwZg4bwwoaeHfFF-jKovFZH-yo8Zaz28d1YrsMuQQUIEQ&pv_id={15C49ABE-7C9F-DF6D-41B4-9BD38A2D21CC}&cid=2&cat=2&rss_source=pojoksatu&fr=1&hj=0&o=2&p=1&skip_ad=0","source":"https://pojoksatu.id/news/berita-nasional/2018/11/09/kronologis-penyerangan-polsek-penjaringan-bermula-parkir-motor/","keywords":null,"desc":"Kabid Humas Polda Metro Jaya Kombes Argo Yuwono       POJOKSATU.id, JAKARTA \u2013 Polsek Penjaringan,","user_id":null,"cover_img":["http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/e6/e67090b661d75152a6868705c698c2f843698cd6.jpg"],"cover_show_type":0,"author_avatar":"http://sta.beritaqu.net/image/avatar/default.jpg?x-oss-process=image/resize,m_fill,h_160,w_160","author_name":"pojoksatu","uni":"4165518","language":"in","du_type":0,"create_time":"2018-11-08 19:39:18","update_time":null,"channel":"Kubik","type_id":2,"visit_count":3,"like_count":0,"comment_count":0,"can_comment":1,"unlike_enable":0,"unlike_count":null,"share_count":0,"listorder":0,"status":1,"is_gold":0,"is_redpack":0,"is_ad":0,"open_browser":0,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"","display_type":1,"news_stop_second":15000,"is_liked":false}],"is_has_more":true}
     */

    private String code;
    private String msg;
    private DataBeanX data;

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

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * data : [{"id":278,"title":"Pemilik Toko Tetap Buka saat Azan, Wakil Bupati Aceh Besar Naik Pitam Sambil Bawa Kayu","href":"http://article.kubiknews.com/detail/2018/11/09/4166042.html?content_id=4166042&key=def5RUlJvqAs8ZtCgbsnKm1jnydRtSzwJiWd4Ot04v9IhWgiR6OoT67fJSvbTgeVKnVs2YQpP3aCV5_UcfS2p6S7vXqxM5L2Q4Fud8_ZIwWj9RZ7hD1WNidNwd6HpMXYGQ&pv_id={05E6478B-EE04-1256-482F-942F72A9D12B}&cid=2&cat=2&rss_source=babe&fr=1&hj=0&o=2&p=1&skip_ad=0","source":"http://news.rakyatku.com/read/126891/2018/11/09/pemilik-toko-tetap-buka-saat-azan-wakil-bupati-aceh-besar-naik-pitam-sambil-bawa-kayu","keywords":null,"desc":"Wakil Bupati Aceh Besar, Husaini A Wahab menegur pemilik toko yang mengabaikan azan. (FOTO: SERAM","user_id":null,"cover_img":["http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/2f/2fe9bc07c128392ad47b6b4f5210b3683e5b071f.jpg"],"cover_show_type":0,"author_avatar":"http://sta.beritaqu.net/image/avatar/default.jpg?x-oss-process=image/resize,m_fill,h_160,w_160","author_name":"Rakyatku","uni":"4166042","language":"in","du_type":0,"create_time":"2018-11-08 20:16:47","update_time":null,"channel":"Kubik","type_id":2,"visit_count":0,"like_count":0,"comment_count":0,"can_comment":1,"unlike_enable":0,"unlike_count":null,"share_count":0,"listorder":0,"status":1,"is_gold":1,"is_redpack":0,"is_ad":0,"open_browser":0,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"","display_type":1,"news_stop_second":15000,"is_liked":false},{"id":277,"title":"Calon Juara, Inilah 7 Tim yang Belum Terkalahkan di Liga-liga Eropa","href":"http://article.kubiknews.com/detail/2018/11/09/4166312.html?content_id=4166312&key=179bJeave2xO0psCDN-3Ldw4l0-aH_N5qEjwzJ3LlmkE2COTnpbzwzrRq9IifH8RYEo0hEj4KvambB3lzntj14B0r26ZCkKJz9mrpvvINY21pnjWs296pv8m-niWAkBUhw&pv_id={05E6478B-EE04-1256-482F-942F72A9D12B}&cid=2&cat=2&rss_source=IDNTimes&fr=1&hj=0&o=2&p=1&skip_ad=0","source":"https://www.idntimes.com/sport/soccer/ganjar-firmansyah/tim-yang-belum-terkalahkan-di-liga-liga-eropa-c1c2","keywords":null,"desc":"Liga-liga Eropa selalu menjadi kiblat sepak bola dunia. Tak hanya diisi oleh deretan pemain hebat d","user_id":null,"cover_img":["http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/53/53f6c0949c6e7106352b4a10e616ee4311cd340c.jpg","http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/45/453e2caaf0f3f10f8a6b6c7b470781bdb65a5c0e.jpg","http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/41/414e256e9ceb53f0f7122680bfc8556ccede63fa.jpg"],"cover_show_type":0,"author_avatar":"http://sta.beritaqu.net/image/avatar/default.jpg?x-oss-process=image/resize,m_fill,h_160,w_160","author_name":"IDNTimes","uni":"4166312","language":"in","du_type":0,"create_time":"2018-11-08 20:16:47","update_time":null,"channel":"Kubik","type_id":2,"visit_count":1,"like_count":0,"comment_count":0,"can_comment":1,"unlike_enable":0,"unlike_count":null,"share_count":0,"listorder":0,"status":1,"is_gold":1,"is_redpack":0,"is_ad":0,"open_browser":0,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"","display_type":1,"news_stop_second":15000,"is_liked":false},{"id":276,"title":"Kisah Mendebarkan saat Pesawat Garuda Indonesia GA421 Lakukan Pendaratan Darurat di Atas Sungai Bengawan Solo","href":"http://article.kubiknews.com/detail/2018/11/09/4166149.html?content_id=4166149&key=80e68usluQBXWeaaHlhtxrb8LOaXcGLjFl3gRHK73NjVVWaDsedz4eVyrhM-AE3tZn5p6kmR3Jcuup0-piaRTwAS8A0B6T9c8ezUYxaadqCxDvV6uCmFOLD-mWuiqFvxXQ&pv_id={AD9A7E5C-A898-BA1C-504B-B7550218DFEF}&cid=2&cat=2&rss_source=Stringisari&fr=1&hj=0&o=2&p=1&skip_ad=0","source":"http://Stringisari.grid.id/read/03994525/kisah-mendebarkan-saat-pesawat-garuda-indonesia-ga421-lakukan-pendaratan-darurat-di-atas-sungai-bengawan-solo","keywords":null,"desc":"Pesawat Garuda Indonesia.     Stringisari-Online.com \u2013 Lion Air menjadi pembicaraan di Indonesia da","user_id":null,"cover_img":["http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/f7/f70084df8c0e9ea444e623f7d11a2b2275f0c842.jpg"],"cover_show_type":0,"author_avatar":"http://sta.beritaqu.net/image/avatar/default.jpg?x-oss-process=image/resize,m_fill,h_160,w_160","author_name":"Stringisari","uni":"4166149","language":"in","du_type":0,"create_time":"2018-11-08 20:12:34","update_time":null,"channel":"Kubik","type_id":2,"visit_count":1,"like_count":0,"comment_count":0,"can_comment":1,"unlike_enable":0,"unlike_count":null,"share_count":0,"listorder":0,"status":1,"is_gold":1,"is_redpack":0,"is_ad":0,"open_browser":0,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"","display_type":1,"news_stop_second":15000,"is_liked":false},{"id":0,"title":1,"href":2,"source":3,"keywords":4,"desc":5,"user_id":6,"cover_img":7,"cover_show_type":8,"author_avatar":9,"author_name":10,"uni":11,"language":12,"du_type":13,"create_time":14,"update_time":15,"channel":16,"type_id":17,"visit_count":18,"like_count":19,"comment_count":20,"can_comment":21,"unlike_enable":22,"unlike_count":23,"share_count":24,"listorder":25,"status":26,"is_gold":27,"is_redpack":28,"is_ad":1,"open_browser":30,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"101","display_type":33,"news_stop_second":34,"is_liked":false},{"id":275,"title":"5 Seleb Indonesia ini Punya Ibu Sambung yang Usianya Tak Terpaut Jauh. Kaya Kakak Beradik","href":"http://article.kubiknews.com/detail/2018/11/09/4166305.html?content_id=4166305&key=bc2chmbhdPk08C5Rj_SBTt5HIrUuBVQ7vb6RcN-zEE5HMVXQJdPDGUx-LXPrO2B0WgiY23brW8mWjJ1IIOmddBQEQY3TEBwDeW_HACMgrJqElbgd-SAcTjRWV4obCFamaA&pv_id={AD9A7E5C-A898-BA1C-504B-B7550218DFEF}&cid=2&cat=2&rss_source=cewekbanget&fr=1&hj=0&o=2&p=1&skip_ad=0","source":"http://cewekbanget.grid.id/read/06994569/5-seleb-indonesia-ini-punya-ibu-sambung-yang-usianya-tak-terpaut-jauh-kaya-kakak-beradik","keywords":null,"desc":"Kolase Cewekbanget.id     Cewekbanget.id \u2013 Dalam sebuah drama atau cerita dongeng, peran ibu sambu","user_id":null,"cover_img":["http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/18/1812bc5de1b363534d2f90c8909bb5036c109282.jpg","http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/d7/d72181dfd36773093ae22716b06e236405a6aa5b.jpg","http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/05/051e66bdbfd81045fe86b1e8c567db9aab42a6e6.jpg"],"cover_show_type":0,"author_avatar":"http://sta.beritaqu.net/image/avatar/default.jpg?x-oss-process=image/resize,m_fill,h_160,w_160","author_name":"cewekbanget","uni":"4166305","language":"in","du_type":0,"create_time":"2018-11-08 20:12:34","update_time":null,"channel":"Kubik","type_id":2,"visit_count":1,"like_count":0,"comment_count":0,"can_comment":1,"unlike_enable":0,"unlike_count":null,"share_count":0,"listorder":0,"status":1,"is_gold":1,"is_redpack":0,"is_ad":0,"open_browser":0,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"","display_type":1,"news_stop_second":15000,"is_liked":false},{"id":274,"title":"Bawa Golok dan Membabi Buta, Seorang Warga Serang Polsek Penjaringan","href":"http://article.kubiknews.com/detail/2018/11/09/4166318.html?content_id=4166318&key=541ffT75hEnWtJhZ_wWhfk8m4JQpo2mJwRuVsPgo4JPqjui6qRNaITsdNtZ9HsEFkGjvS5C4-N3RlOEKI30N4pfl4d4UA2aBwxnzY1X7SR6czdOvS2wB30H7mqqFoxIOVA&pv_id={AD9A7E5C-A898-BA1C-504B-B7550218DFEF}&cid=2&cat=2&rss_source=covesia&fr=1&hj=0&o=2&p=1&skip_ad=0","source":"https://covesia.com/news/baca/63485/bawa-golok-dan-membabi-buta-seorang-warga-serang-polsek-penjaringan","keywords":null,"desc":"Penyerang Polsek Penjaringan. Foto: detikcom/ istimewa  Covesia.com - Seorang pria bernama Rohandi","user_id":null,"cover_img":["http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/b9/b92c241fd13bee278aca3f45f767b9ab69fa295c.jpg"],"cover_show_type":0,"author_avatar":"http://sta.beritaqu.net/image/avatar/default.jpg?x-oss-process=image/resize,m_fill,h_160,w_160","author_name":"covesia","uni":"4166318","language":"in","du_type":0,"create_time":"2018-11-08 20:12:34","update_time":null,"channel":"Kubik","type_id":2,"visit_count":0,"like_count":0,"comment_count":0,"can_comment":1,"unlike_enable":0,"unlike_count":null,"share_count":0,"listorder":0,"status":1,"is_gold":1,"is_redpack":0,"is_ad":0,"open_browser":0,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"","display_type":1,"news_stop_second":15000,"is_liked":false},{"id":273,"title":"Pelaku Mabuk Air Rebusan Pembalut Susah Dijerat Hukum Karena Pembalut Bukan Termasuk Narkoba","href":"http://article.kubiknews.com/detail/2018/11/09/4164656.html?content_id=4164656&key=0359SRtLTV2BSBErEj_1GtykIzppo9WVgFl6GwEMwwN4Kv_tyx-3oEeqHMdiECVbYYaBiG9jGO_r3QZCYjJPazcCryURf0In0qhpwMKsjablX3rgW8enE8eeo3IPIy_ZyQ&pv_id={CF9EC17E-F351-1B41-7C4D-09B2620ADCE3}&cid=2&cat=2&rss_source=mojok&fr=1&hj=0&o=2&p=1&skip_ad=0","source":"https://mojok.co/red/rame/kilas/pelaku-mabuk-air-rebusan-pembalut-susah-dijerat-hukum-karena-pembalut-bukan-termasuk-narkoba/","keywords":null,"desc":"Salah satu humor lawas paling legendaris tentang penggunaan pembalut sebagai sebuah konsumsi adalah","user_id":null,"cover_img":["http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/29/29ef29b987c2830017f9cf4e4699a5029cf63840.jpg"],"cover_show_type":0,"author_avatar":"http://sta.beritaqu.net/image/avatar/default.jpg?x-oss-process=image/resize,m_fill,h_160,w_160","author_name":"mojok","uni":"4164656","language":"in","du_type":0,"create_time":"2018-11-08 20:09:04","update_time":null,"channel":"Kubik","type_id":2,"visit_count":56,"like_count":1,"comment_count":0,"can_comment":1,"unlike_enable":0,"unlike_count":null,"share_count":5,"listorder":0,"status":1,"is_gold":1,"is_redpack":0,"is_ad":0,"open_browser":0,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"","display_type":1,"news_stop_second":15000,"is_liked":false},{"id":0,"title":1,"href":2,"source":3,"keywords":4,"desc":5,"user_id":6,"cover_img":7,"cover_show_type":8,"author_avatar":9,"author_name":10,"uni":11,"language":12,"du_type":13,"create_time":14,"update_time":15,"channel":16,"type_id":17,"visit_count":18,"like_count":19,"comment_count":20,"can_comment":21,"unlike_enable":22,"unlike_count":23,"share_count":24,"listorder":25,"status":26,"is_gold":27,"is_redpack":28,"is_ad":1,"open_browser":30,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"101","display_type":33,"news_stop_second":34,"is_liked":false},{"id":271,"title":"Mayangsari Sempat Ketahuan Merokok, Ini Penampilannya Saat Arisan Bersama Para Seleb","href":"http://article.kubiknews.com/detail/2018/11/09/4165940.html?content_id=4165940&key=ab713YvbQx4HooqCZ787sM9ASZ296ZGFkXezsTOqVsS6C0J7UX-qqmNaAkk3TU-GaXnZ3_WbJqDEGL25UohE_7iALFmissphJI2Fee_k-ERnObH18bn2gjlBt81a1MB84Q&pv_id={4107881B-7EB3-24B4-C0E1-414B013F6446}&cid=2&cat=2&rss_source=nakita&fr=1&hj=0&o=2&p=1&skip_ad=0","source":"http://nakita.grid.id/read/02994582/mayangsari-sempat-ketahuan-merokok-ini-penampilannya-saat-arisan-bersama-para-seleb","keywords":null,"desc":"Instagram/mayangsaritrihatmodjoreal  Mayangsari bersama suami dan anaknya   Sosok artis senior  mu","user_id":null,"cover_img":["http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/3a/3af435b5d6f04c490011e1e962cea9a5aefa6ed8.jpg","http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/3f/3f04453ebf038b4637dcce55a4f385e9ffec3bed.jpg","http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/fa/fa95ce6b443c30dbab05d80fa65855a8bf119143.jpg"],"cover_show_type":0,"author_avatar":"http://sta.beritaqu.net/image/avatar/default.jpg?x-oss-process=image/resize,m_fill,h_160,w_160","author_name":"nakita","uni":"4165940","language":"in","du_type":0,"create_time":"2018-11-08 20:00:06","update_time":null,"channel":"Kubik","type_id":2,"visit_count":0,"like_count":0,"comment_count":0,"can_comment":1,"unlike_enable":0,"unlike_count":null,"share_count":0,"listorder":0,"status":1,"is_gold":1,"is_redpack":0,"is_ad":0,"open_browser":0,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"","display_type":1,"news_stop_second":15000,"is_liked":false},{"id":270,"title":"Viral, Video Anak SD di Sukabumi Merokok di Sekolah, Begini Faktanya !","href":"http://article.kubiknews.com/detail/2018/11/09/4165943.html?content_id=4165943&key=0222T59PASUmzk1IBa06mvbSpfUone09yH9s13Hu16yw5uA2wOj27bcU2kaY3sQlN9Cd8n4XWy6L47p2OdIexR9G4mHJz1GKkV6ZSo3jQQlwV3GKvIxptK8i6Z6NlgREmQ&pv_id={4107881B-7EB3-24B4-C0E1-414B013F6446}&cid=2&cat=2&rss_source=Indowarta&fr=1&hj=0&o=2&p=1&skip_ad=0","source":"https://indowarta.com/72858/viral-video-anak-sd-di-sukabumi-merokok-di-sekolah-begini-faktanya/","keywords":null,"desc":"Copyright©detik Video Anak SD di Sukabumi Merokok di Sekolah Jadi Sorotan Publik ! Indowarta.com \u2013 B","user_id":null,"cover_img":["http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/5a/5a832526cade27f830ccdaf4f3f597ff25c9ca50.jpg"],"cover_show_type":0,"author_avatar":"http://sta.beritaqu.net/image/avatar/default.jpg?x-oss-process=image/resize,m_fill,h_160,w_160","author_name":"Indowarta","uni":"4165943","language":"in","du_type":0,"create_time":"2018-11-08 20:00:06","update_time":null,"channel":"Kubik","type_id":2,"visit_count":0,"like_count":0,"comment_count":0,"can_comment":1,"unlike_enable":0,"unlike_count":null,"share_count":0,"listorder":0,"status":1,"is_gold":1,"is_redpack":0,"is_ad":0,"open_browser":0,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"","display_type":1,"news_stop_second":15000,"is_liked":false},{"id":269,"title":"Pelaku Sempat Teriakkan Takbir saat Serang Polsek Penjaringan","href":"http://article.kubiknews.com/detail/2018/11/09/4165858.html?content_id=4165858&key=8ec73QhsSrG4WJ4s0koYOh5-YoWdyELj_Qj446VNgEjp-o-wQa8fQT_Qug2h_0suexKa1lP_44bWTRfpGrUJ9MMnk_iPfPHA6o4vz27vq77XixU7XdahzyHFtYn9eLimSQ&pv_id={94FF9D42-D3E7-9626-3460-A9C6520C6596}&cid=2&cat=2&rss_source=Okezone&fr=1&hj=0&o=2&p=1&skip_ad=0","source":"https://news.okezone.com/read/2018/11/09/338/1975395/pelaku-sempat-teriakkan-takbir-saat-serang-polsek-penjaringan","keywords":null,"desc":"Kaca di salah satu ruangan mapolsek Metro Penjaringan pecah akibat diserang seorang pria. (Ist)","user_id":null,"cover_img":["http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/ae/aea6464c82fc9e0e0782897614ff5a65ab1d7a49.jpg"],"cover_show_type":0,"author_avatar":"http://sta.beritaqu.net/image/avatar/default.jpg?x-oss-process=image/resize,m_fill,h_160,w_160","author_name":"Okezone","uni":"4165858","language":"in","du_type":0,"create_time":"2018-11-08 19:55:59","update_time":null,"channel":"Kubik","type_id":2,"visit_count":0,"like_count":0,"comment_count":0,"can_comment":1,"unlike_enable":0,"unlike_count":null,"share_count":0,"listorder":0,"status":1,"is_gold":0,"is_redpack":0,"is_ad":0,"open_browser":0,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"","display_type":1,"news_stop_second":15000,"is_liked":false},{"id":268,"title":"Polsek Penjaringan Diserang Pria Misterius, 1 Polisi Terluka","href":"http://article.kubiknews.com/detail/2018/11/09/4165859.html?content_id=4165859&key=dfffnzuVlWmssEPFI-L_3ymA_mcNz_3AeFbk_zrTfun7KgYuyp3sSrSbfS_ScS1wgPI9u0imLc1KM19SVx7YW6KnYFaNMsYOYQrZ_av30-1iAgiB04DE0JqOj97ffaSAog&pv_id={94FF9D42-D3E7-9626-3460-A9C6520C6596}&cid=2&cat=2&rss_source=Okezone&fr=1&hj=0&o=2&p=1&skip_ad=0","source":"https://news.okezone.com/read/2018/11/09/338/1975392/polsek-penjaringan-diserang-pria-misterius-1-polisi-terluka","keywords":null,"desc":"Karo Penmas Divisi Humas Polri, Brigjen Dedi Prasetyo. (Foto : Puteranegara Batubara/Okezone)  JAK","user_id":null,"cover_img":["http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/d7/d7f79bcd66a52df9b6a069a9ef48cc6db735e583.jpg"],"cover_show_type":0,"author_avatar":"http://sta.beritaqu.net/image/avatar/default.jpg?x-oss-process=image/resize,m_fill,h_160,w_160","author_name":"Okezone","uni":"4165859","language":"in","du_type":0,"create_time":"2018-11-08 19:55:59","update_time":null,"channel":"Kubik","type_id":2,"visit_count":1,"like_count":0,"comment_count":0,"can_comment":1,"unlike_enable":0,"unlike_count":null,"share_count":0,"listorder":0,"status":1,"is_gold":0,"is_redpack":0,"is_ad":0,"open_browser":0,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"","display_type":1,"news_stop_second":15000,"is_liked":false},{"id":0,"title":1,"href":2,"source":3,"keywords":4,"desc":5,"user_id":6,"cover_img":7,"cover_show_type":8,"author_avatar":9,"author_name":10,"uni":11,"language":12,"du_type":13,"create_time":14,"update_time":15,"channel":16,"type_id":17,"visit_count":18,"like_count":19,"comment_count":20,"can_comment":21,"unlike_enable":22,"unlike_count":23,"share_count":24,"listorder":25,"status":26,"is_gold":27,"is_redpack":28,"is_ad":1,"open_browser":30,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"102","display_type":33,"news_stop_second":34,"is_liked":false},{"id":267,"title":"Jennifer Bachdim Tampil Mempesona di Victoria's Secret Fashion Show 2018, Irfan Bachdim Bangga!","href":"http://article.kubiknews.com/detail/2018/11/09/4165488.html?content_id=4165488&key=83b0fQcX9td4EoDsKhzfQAWuIrSQSHCxcMtT5gEBOhF4dJsw0g2HX-tvF2hYV6QZFtFQXFo9o3u96t0Re2R-NN4yXxiJgj8RJ6_lISNx-ja5XZbo15fhl6Gz4Sz0cKYOfw&pv_id={944F8132-CE2E-622D-182E-3C9829F595D8}&cid=2&cat=2&rss_source=grid+ID&fr=1&hj=0&o=2&p=1&skip_ad=0","source":"http://www.grid.id/read/04994588/jennifer-bachdim-tampil-mempesona-di-victorias-secret-fashion-show-2018-irfan-bachdim-bangga","keywords":null,"desc":"Laporan Wartawan Grid.ID, Dwi Ayu Lestari Grid.ID - Jennifer Bachdim tak menyia-nyiakan kesempat","user_id":null,"cover_img":["http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/f7/f7fbb8ebc303420920779ec429dd866a6a20ef0a.jpg","http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/d4/d4d14cdfab8ae9f786b602f60cdb312ab589a167.jpg","http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/f4/f4376b1507684bf25532c4032a06f1b9a3241b3a.jpg"],"cover_show_type":0,"author_avatar":"http://sta.beritaqu.net/image/avatar/default.jpg?x-oss-process=image/resize,m_fill,h_160,w_160","author_name":"grid ID","uni":"4165488","language":"in","du_type":0,"create_time":"2018-11-08 19:51:46","update_time":null,"channel":"Kubik","type_id":2,"visit_count":5,"like_count":0,"comment_count":0,"can_comment":1,"unlike_enable":0,"unlike_count":null,"share_count":1,"listorder":0,"status":1,"is_gold":0,"is_redpack":0,"is_ad":0,"open_browser":0,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"","display_type":1,"news_stop_second":15000,"is_liked":false},{"id":266,"title":"Piala AFF 2018 - Pelatih Singapura Iri dengan Kemampuan Pemain Timnas Indonesia","href":"http://article.kubiknews.com/detail/2018/11/09/4165711.html?content_id=4165711&key=2ea7wVuyZhl2_0YsHaq5xM1cRnjN2pQhrRnyPBoqnrxcDsHOCa_XMNHzhLM5DwYVbYqlR_Jp5rrMuyp-7s2hPXMGxZZWCheCIFSrPh7JXFIIQlXwYgcQ9zsCfHW6SvqtXw&pv_id={944F8132-CE2E-622D-182E-3C9829F595D8}&cid=2&cat=2&rss_source=bolasport&fr=1&hj=0&o=2&p=1&skip_ad=0","source":"https://www.bolasport.com/timnas/316589-piala-aff-2018--pelatih-singapura-iri-dengan-kemampuan-pemain-timnas-indonesia","keywords":null,"desc":"MUHAMMAD BAGAS/BOLA      BOLASPORT.COM - Pelatih timnas Singapura Fandi Ahmad mengutarakan ras","user_id":null,"cover_img":["http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/df/df8e93a76e01ca3452bce5aaaf8113eeb8cc94b6.jpg"],"cover_show_type":0,"author_avatar":"http://sta.beritaqu.net/image/avatar/default.jpg?x-oss-process=image/resize,m_fill,h_160,w_160","author_name":"bolasport","uni":"4165711","language":"in","du_type":0,"create_time":"2018-11-08 19:51:46","update_time":null,"channel":"Kubik","type_id":2,"visit_count":28,"like_count":1,"comment_count":0,"can_comment":1,"unlike_enable":0,"unlike_count":null,"share_count":2,"listorder":0,"status":1,"is_gold":0,"is_redpack":0,"is_ad":0,"open_browser":0,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"","display_type":1,"news_stop_second":15000,"is_liked":false},{"id":0,"title":1,"href":2,"source":3,"keywords":4,"desc":5,"user_id":6,"cover_img":7,"cover_show_type":8,"author_avatar":9,"author_name":10,"uni":11,"language":12,"du_type":13,"create_time":14,"update_time":15,"channel":16,"type_id":17,"visit_count":18,"like_count":19,"comment_count":20,"can_comment":21,"unlike_enable":22,"unlike_count":23,"share_count":24,"listorder":25,"status":26,"is_gold":27,"is_redpack":28,"is_ad":1,"open_browser":30,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"102","display_type":33,"news_stop_second":34,"is_liked":false},{"id":265,"title":"Potret Jennifer Bachdim Bersama Kendall Jenner dan Model Victoria's Secret Angels Lainnya, Beruntungnya!","href":"http://article.kubiknews.com/detail/2018/11/09/4165870.html?content_id=4165870&key=9eceNfpCytKc4HGKS7weep0-K6L-Nm8OeUm9GgtE5J5ncuZg3FK48qU4SE54wVqG_wCjyAVCt6I80v0_S5it4aoLY-7mCI-GI67JCuZS_6YO6bZs6Gq9q-14eP9mH59O3w&pv_id={944F8132-CE2E-622D-182E-3C9829F595D8}&cid=2&cat=2&rss_source=grid+ID&fr=1&hj=0&o=2&p=1&skip_ad=0","source":"http://www.grid.id/read/04994620/potret-jennifer-bachdim-bersama-kendall-jenner-dan-model-victorias-secret-angels-lainnya-beruntungnya","keywords":null,"desc":"Laporan Wartawan Grid.ID, Dwi Ayu Lestari Grid.ID - Jennifer Bachdim tampaknya jadi sport enthus","user_id":null,"cover_img":["http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/3d/3d65cea88b838f0f2e103876525a7cb4470697a8.jpg","http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/38/38559f479d600a21c694b20d658aa136e5307138.jpg","http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/40/40077260747ee7b5f7462242fea941fec547df71.jpg"],"cover_show_type":0,"author_avatar":"http://sta.beritaqu.net/image/avatar/default.jpg?x-oss-process=image/resize,m_fill,h_160,w_160","author_name":"grid ID","uni":"4165870","language":"in","du_type":0,"create_time":"2018-11-08 19:51:46","update_time":null,"channel":"Kubik","type_id":2,"visit_count":0,"like_count":0,"comment_count":0,"can_comment":1,"unlike_enable":0,"unlike_count":null,"share_count":0,"listorder":0,"status":1,"is_gold":0,"is_redpack":0,"is_ad":0,"open_browser":0,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"","display_type":1,"news_stop_second":15000,"is_liked":false},{"id":264,"title":"Pencarian Hari Ke 11, Basarnas Temukan 8 Potongan Tubuh","href":"http://article.kubiknews.com/detail/2018/11/09/4164132.html?content_id=4164132&key=45c46OvCda2NIZAsW2y2YjAxSbzmm5yu24CYPg07Gem7re5vwoP0LI8El_JynbrDjRt1ofVcO9cC6FZ4w3X2pP4rAlL0EyaPMe93BfTbpH-58w4kOslNVOGXdTFA4h3XVA&pv_id={B2FC9E7C-1883-6947-573D-4BB08A410714}&cid=2&cat=2&rss_source=grid+ID&fr=1&hj=0&o=2&p=1&skip_ad=0","source":"http://www.grid.id/read/04994512/pencarian-hari-ke-11-basarnas-temukan-8-potongan-tubuh","keywords":null,"desc":"Laporan Wartawan Grid.ID - Lalu Hendri Bagus Grid.ID - Tim SAR gabungan terus berupaya mencari k","user_id":null,"cover_img":["http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/fa/fa5e31e5704a69b6e4a1b5663ad01f88d35a790d.jpg"],"cover_show_type":0,"author_avatar":"http://sta.beritaqu.net/image/avatar/default.jpg?x-oss-process=image/resize,m_fill,h_160,w_160","author_name":"grid ID","uni":"4164132","language":"in","du_type":0,"create_time":"2018-11-08 19:47:44","update_time":null,"channel":"Kubik","type_id":2,"visit_count":17,"like_count":2,"comment_count":0,"can_comment":1,"unlike_enable":0,"unlike_count":null,"share_count":0,"listorder":0,"status":1,"is_gold":0,"is_redpack":0,"is_ad":0,"open_browser":0,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"","display_type":1,"news_stop_second":15000,"is_liked":false},{"id":263,"title":"Gagal capai target, karyawan disuruh minum air kencing dan makan kecoa","href":"http://article.kubiknews.com/detail/2018/11/09/4165295.html?content_id=4165295&key=f94esise2LogKmykkwqOhknCJp6dqoPuvLpY3zSwEN7WBovLZ5WGyfiQsh9S_WDTaX1ghlOvCqt3vzn4oOuSJh_H_hAJMZe101BWc9LGZuINMBfVepqck61VbswUMajoeQ&pv_id={B2FC9E7C-1883-6947-573D-4BB08A410714}&cid=2&cat=2&rss_source=batok&fr=1&hj=0&o=2&p=1&skip_ad=0","source":"https://www.batok.co/2018/11/09/gagal-capai-target-karyawan-disuruh-minum-air-kencing-dan-makan-kecoa/","keywords":null,"desc":"Foto: WeiboSebuah perusahaan perlengkapan rumah di Zunyi, Guizhou, China terekam kamera menghukum de","user_id":null,"cover_img":["http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/a5/a5409d636163507abc8067f15ce4e7e02075fe25.jpg"],"cover_show_type":0,"author_avatar":"http://sta.beritaqu.net/image/avatar/default.jpg?x-oss-process=image/resize,m_fill,h_160,w_160","author_name":"batok","uni":"4165295","language":"in","du_type":0,"create_time":"2018-11-08 19:47:44","update_time":null,"channel":"Kubik","type_id":2,"visit_count":13,"like_count":1,"comment_count":0,"can_comment":1,"unlike_enable":0,"unlike_count":null,"share_count":0,"listorder":0,"status":1,"is_gold":0,"is_redpack":0,"is_ad":0,"open_browser":0,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"","display_type":1,"news_stop_second":15000,"is_liked":false},{"id":262,"title":"Atiqah Hasiholan Sebut Ratna Sarumpaet Depresi, Kuasa Hukum MStringa Perlakuan Khusus","href":"http://article.kubiknews.com/detail/2018/11/09/4165328.html?content_id=4165328&key=960elrOyrzoX2SD02jvEHHijIVpd9EA9zzlbbjMKnCSggv2Dbky6CyvDD3mQWuwEsU1pSt0vJ6-VZ2KkwI08Rtn_3Wek_mJvAe86lKGhPZEZctSMvR9oZt1c6hOWTCR3qA&pv_id={A9327FEC-6F92-75EB-07AC-A54C8015C616}&cid=2&cat=2&rss_source=malangtoday&fr=1&hj=0&o=2&p=1&skip_ad=0","source":"https://malangtoday.net/inspirasi/hiburan/atiqah-hasiholan-ratna-sarumpaet-depresi/","keywords":null,"desc":"Selebriti sekaligus putri dari aktivis dan politikus Ratna Sarumpaet, Atiqah Hasiholan akhirnya buka","user_id":null,"cover_img":["http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/5b/5bc92b19ec223e954f4a57f1c231c3ef8701417d.jpg"],"cover_show_type":0,"author_avatar":"http://sta.beritaqu.net/image/avatar/default.jpg?x-oss-process=image/resize,m_fill,h_160,w_160","author_name":"malangtoday","uni":"4165328","language":"in","du_type":0,"create_time":"2018-11-08 19:47:38","update_time":null,"channel":"Kubik","type_id":2,"visit_count":9,"like_count":0,"comment_count":0,"can_comment":1,"unlike_enable":0,"unlike_count":null,"share_count":0,"listorder":0,"status":1,"is_gold":0,"is_redpack":0,"is_ad":0,"open_browser":0,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"","display_type":1,"news_stop_second":15000,"is_liked":false},{"id":261,"title":"Asal Usul Cincin Kawin Dipakai di Jari Manis Tangan Kiri","href":"http://article.kubiknews.com/detail/2018/11/09/4165472.html?content_id=4165472&key=4b85rVBkI9rvUAAJlmjopuXhd5bIXjM4F10cC0mMlBU9Eh5HRalB8FfM3gZE8APWVX240U_6TbFpwb4igJ_IWLrOm9dfuSI-pMnDhjQoIBEgZBpvx3sd3oGXEEKxFn_Qdw&pv_id={A9327FEC-6F92-75EB-07AC-A54C8015C616}&cid=2&cat=2&rss_source=babe&fr=1&hj=0&o=2&p=1&skip_ad=0","source":"https://www.hetanews.com/article/142533/asal-usul-cincin-kawin-dipakai-di-jari-manis-tangan-kiri","keywords":null,"desc":"Eropa, hetanews.com - Selama bertahun-tahun, hampir semua pasangan selalu memakai cincin kawin pa","user_id":null,"cover_img":["http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/22/2262ce4851a141079cbc3f52f277c6f005ed5d43.jpg"],"cover_show_type":0,"author_avatar":"http://sta.beritaqu.net/image/avatar/default.jpg?x-oss-process=image/resize,m_fill,h_160,w_160","author_name":"Hetanews","uni":"4165472","language":"in","du_type":0,"create_time":"2018-11-08 19:47:38","update_time":null,"channel":"Kubik","type_id":2,"visit_count":0,"like_count":0,"comment_count":0,"can_comment":1,"unlike_enable":0,"unlike_count":null,"share_count":0,"listorder":0,"status":1,"is_gold":0,"is_redpack":0,"is_ad":0,"open_browser":0,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"","display_type":1,"news_stop_second":15000,"is_liked":false},{"id":0,"title":1,"href":2,"source":3,"keywords":4,"desc":5,"user_id":6,"cover_img":7,"cover_show_type":8,"author_avatar":9,"author_name":10,"uni":11,"language":12,"du_type":13,"create_time":14,"update_time":15,"channel":16,"type_id":17,"visit_count":18,"like_count":19,"comment_count":20,"can_comment":21,"unlike_enable":22,"unlike_count":23,"share_count":24,"listorder":25,"status":26,"is_gold":27,"is_redpack":28,"is_ad":1,"open_browser":30,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"101","display_type":33,"news_stop_second":34,"is_liked":false},{"id":259,"title":"Cuek Mayangsari Ngerokok Dekat Momo yang Hamil, Geng Artis Kepompong Dibully Dukung Pelakor","href":"http://article.kubiknews.com/detail/2018/11/09/4165836.html?content_id=4165836&key=7f76IJuhAw_dAjXupQ9QdRJE4OB5gBj9gxofSHmOyXimr1-NiJIHka9A-sa48DpT5_tT2XNfNvkQMHFSbRV3GXB4mGewfMv74CR-FJ85_B8PdqH7KN-vxH6LWEnR4ukZOQ&pv_id={A9327FEC-6F92-75EB-07AC-A54C8015C616}&cid=2&cat=2&rss_source=wowkeren&fr=1&hj=0&o=2&p=1&skip_ad=0","source":"https://www.wowkeren.com/berita/tampil/00231507.html","keywords":null,"desc":"Geng Iis Dahlia, Melly Goeslaw, Rossa dkk dinilai kalah dari squad Nia Ramadhani cs yang mendepak me","user_id":null,"cover_img":["http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/d7/d755e5ce80fa44d4f043e513814f2df4beeba359.jpg"],"cover_show_type":0,"author_avatar":"http://sta.beritaqu.net/image/avatar/default.jpg?x-oss-process=image/resize,m_fill,h_160,w_160","author_name":"wowkeren","uni":"4165836","language":"in","du_type":0,"create_time":"2018-11-08 19:47:38","update_time":null,"channel":"Kubik","type_id":2,"visit_count":0,"like_count":0,"comment_count":0,"can_comment":1,"unlike_enable":0,"unlike_count":null,"share_count":0,"listorder":0,"status":1,"is_gold":0,"is_redpack":0,"is_ad":0,"open_browser":0,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"","display_type":1,"news_stop_second":15000,"is_liked":false},{"id":258,"title":"Pelaku Penyerang Polsek Penjaringan Depresi dan Ingin Mati Ditembak Polisi","href":"http://article.kubiknews.com/detail/2018/11/09/4165253.html?content_id=4165253&key=aff6AD3ZG1Wq-6qpBOP7wzB4BIyfoYsTclQGhF6EFvQ8FWTv42ddvfSMTDX_HHa1MXQ9wmc6Ctsss_gQGCoCJjSSft2j_x4uHm7fysDbssbiGQRxyW3ohtcIO--p7LgMOA&pv_id={15C49ABE-7C9F-DF6D-41B4-9BD38A2D21CC}&cid=2&cat=2&rss_source=babe&fr=1&hj=0&o=2&p=1&skip_ad=0","source":"http://poskotanews.com/2018/11/09/pelaku-penyerang-polsek-penjaringan-depresi-dan-ingin-mati-ditembak-polisi/","keywords":null,"desc":"JAKARTA \u2013 Luka tembak di pangkal lengan, mengakhiri aksi brutal Rohandi (31),  pria yang menyeran","user_id":null,"cover_img":["http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/ad/adf0a9322fc7f6ad0014d10f2507961d334517e3.jpg"],"cover_show_type":0,"author_avatar":"http://sta.beritaqu.net/image/avatar/default.jpg?x-oss-process=image/resize,m_fill,h_160,w_160","author_name":"Poskotanews","uni":"4165253","language":"in","du_type":0,"create_time":"2018-11-08 19:39:18","update_time":null,"channel":"Kubik","type_id":2,"visit_count":0,"like_count":0,"comment_count":0,"can_comment":1,"unlike_enable":0,"unlike_count":null,"share_count":0,"listorder":0,"status":1,"is_gold":0,"is_redpack":0,"is_ad":0,"open_browser":0,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"","display_type":1,"news_stop_second":15000,"is_liked":false},{"id":257,"title":"Kronologis Penyerangan Polsek Penjaringan, Bermula dari Parkir Motor","href":"http://article.kubiknews.com/detail/2018/11/09/4165518.html?content_id=4165518&key=dda294PIlzjNgyRjyoTxuRu3TBqmnUho1aH3yeN26dSQh4wLeDiTjpfEhHUUX67c52c5tKLjdoA7d2BzpPN6jAwZg4bwwoaeHfFF-jKovFZH-yo8Zaz28d1YrsMuQQUIEQ&pv_id={15C49ABE-7C9F-DF6D-41B4-9BD38A2D21CC}&cid=2&cat=2&rss_source=pojoksatu&fr=1&hj=0&o=2&p=1&skip_ad=0","source":"https://pojoksatu.id/news/berita-nasional/2018/11/09/kronologis-penyerangan-polsek-penjaringan-bermula-parkir-motor/","keywords":null,"desc":"Kabid Humas Polda Metro Jaya Kombes Argo Yuwono       POJOKSATU.id, JAKARTA \u2013 Polsek Penjaringan,","user_id":null,"cover_img":["http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/e6/e67090b661d75152a6868705c698c2f843698cd6.jpg"],"cover_show_type":0,"author_avatar":"http://sta.beritaqu.net/image/avatar/default.jpg?x-oss-process=image/resize,m_fill,h_160,w_160","author_name":"pojoksatu","uni":"4165518","language":"in","du_type":0,"create_time":"2018-11-08 19:39:18","update_time":null,"channel":"Kubik","type_id":2,"visit_count":3,"like_count":0,"comment_count":0,"can_comment":1,"unlike_enable":0,"unlike_count":null,"share_count":0,"listorder":0,"status":1,"is_gold":0,"is_redpack":0,"is_ad":0,"open_browser":0,"ad_otherMsg":{"imp":[],"clk":[]},"ad_type":"","display_type":1,"news_stop_second":15000,"is_liked":false}]
         * is_has_more : true
         */

        private boolean is_has_more;
        private List<DataBean> data;

        public boolean isIs_has_more() {
            return is_has_more;
        }

        public void setIs_has_more(boolean is_has_more) {
            this.is_has_more = is_has_more;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean implements MultiItemEntity,Parcelable {
            @Override
            public String toString() {
                return "DataBean{" +
                        "id='" + id + '\'' +
                        ", title='" + title + '\'' +
                        ", href='" + href + '\'' +
                        ", source='" + source + '\'' +
                        ", keywords='" + keywords + '\'' +
                        ", desc='" + desc + '\'' +
                        ", user_id='" + user_id + '\'' +
                        ", cover_show_type='" + cover_show_type + '\'' +
                        ", author_avatar='" + author_avatar + '\'' +
                        ", author_name='" + author_name + '\'' +
                        ", uni='" + uni + '\'' +
                        ", language='" + language + '\'' +
                        ", du_type='" + du_type + '\'' +
                        ", create_time='" + create_time + '\'' +
                        ", update_time='" + update_time + '\'' +
                        ", channel='" + channel + '\'' +
                        ", type_id='" + type_id + '\'' +
                        ", visit_count='" + visit_count + '\'' +
                        ", like_count='" + like_count + '\'' +
                        ", comment_count='" + comment_count + '\'' +
                        ", can_comment='" + can_comment + '\'' +
                        ", unlike_enable='" + unlike_enable + '\'' +
                        ", unlike_count='" + unlike_count + '\'' +
                        ", share_count='" + share_count + '\'' +
                        ", listorder='" + listorder + '\'' +
                        ", status='" + status + '\'' +
                        ", is_gold='" + is_gold + '\'' +
                        ", is_redpack='" + is_redpack + '\'' +
                        ", is_ad='" + is_ad + '\'' +
                        ", open_browser='" + open_browser + '\'' +
                        ", ad_otherMsg=" + ad_otherMsg +
                        ", ad_type='" + ad_type + '\'' +
                        ", display_type='" + display_type + '\'' +
                        ", news_stop_second='" + news_stop_second + '\'' +
                        ", is_liked=" + is_liked +
                        ", type=" + type +
                        ", cover_img=" + cover_img +
                        '}';
            }

            /**
             * id : 278
             * title : Pemilik Toko Tetap Buka saat Azan, Wakil Bupati Aceh Besar Naik Pitam Sambil Bawa Kayu
             * href : http://article.kubiknews.com/detail/2018/11/09/4166042.html?content_id=4166042&key=def5RUlJvqAs8ZtCgbsnKm1jnydRtSzwJiWd4Ot04v9IhWgiR6OoT67fJSvbTgeVKnVs2YQpP3aCV5_UcfS2p6S7vXqxM5L2Q4Fud8_ZIwWj9RZ7hD1WNidNwd6HpMXYGQ&pv_id={05E6478B-EE04-1256-482F-942F72A9D12B}&cid=2&cat=2&rss_source=babe&fr=1&hj=0&o=2&p=1&skip_ad=0
             * source : http://news.rakyatku.com/read/126891/2018/11/09/pemilik-toko-tetap-buka-saat-azan-wakil-bupati-aceh-besar-naik-pitam-sambil-bawa-kayu
             * keywords : null
             * desc : Wakil Bupati Aceh Besar, Husaini A Wahab menegur pemilik toko yang mengabaikan azan. (FOTO: SERAM
             * user_id : null
             * cover_img : ["http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181109/2f/2fe9bc07c128392ad47b6b4f5210b3683e5b071f.jpg"]
             * cover_show_type : 0
             * author_avatar : http://sta.beritaqu.net/image/avatar/default.jpg?x-oss-process=image/resize,m_fill,h_160,w_160
             * author_name : Rakyatku
             * uni : 4166042
             * language : in
             * du_type : 0
             * create_time : 2018-11-08 20:16:47
             * update_time : null
             * channel : Kubik
             * type_id : 2
             * visit_count : 0
             * like_count : 0
             * comment_count : 0
             * can_comment : 1
             * unlike_enable : 0
             * unlike_count : null
             * share_count : 0
             * listorder : 0
             * status : 1
             * is_gold : 1
             * is_redpack : 0
             * is_ad : 0
             * open_browser : 0
             * ad_otherMsg : {"imp":[],"clk":[]}
             * ad_type :
             * display_type : 1
             * news_stop_second : 15000
             * is_liked : false
             */

            private String id;
            private String title;
            private String href;
            private String source;
            private String keywords;
            private String desc;
            private String user_id;
            private String cover_show_type;
            private String author_avatar;
            private String author_name;
            private String uni;
            private String language;
            private String du_type;
            private String create_time;
            private String update_time;
            private String channel;
            private String type_id;
            private String visit_count;
            private String like_count;
            private String comment_count;
            private String can_comment;
            private String unlike_enable;
            private String unlike_count;
            private String share_count;
            private String listorder;
            private String status;
            private String is_gold;
            private String is_redpack;
            private String is_ad;
            private String open_browser;
            private AdOtherMsgBean ad_otherMsg;
            private String ad_type;
            private String display_type;
            private String news_stop_second;
            private boolean is_liked;
            private int type;
            private List<String> cover_img;

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
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

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getKeywords() {
                return keywords;
            }

            public void setKeywords(String keywords) {
                this.keywords = keywords;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getCover_show_type() {
                return cover_show_type;
            }

            public void setCover_show_type(String cover_show_type) {
                this.cover_show_type = cover_show_type;
            }

            public String getAuthor_avatar() {
                return author_avatar;
            }

            public void setAuthor_avatar(String author_avatar) {
                this.author_avatar = author_avatar;
            }

            public String getAuthor_name() {
                return author_name;
            }

            public void setAuthor_name(String author_name) {
                this.author_name = author_name;
            }

            public String getUni() {
                return uni;
            }

            public void setUni(String uni) {
                this.uni = uni;
            }

            public String getLanguage() {
                return language;
            }

            public void setLanguage(String language) {
                this.language = language;
            }

            public String getDu_type() {
                return du_type;
            }

            public void setDu_type(String du_type) {
                this.du_type = du_type;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getUpdate_time() {
                return update_time;
            }

            public void setUpdate_time(String update_time) {
                this.update_time = update_time;
            }

            public String getChannel() {
                return channel;
            }

            public void setChannel(String channel) {
                this.channel = channel;
            }

            public String getType_id() {
                return type_id;
            }

            public void setType_id(String type_id) {
                this.type_id = type_id;
            }

            public String getVisit_count() {
                return visit_count;
            }

            public void setVisit_count(String visit_count) {
                this.visit_count = visit_count;
            }

            public String getLike_count() {
                return like_count;
            }

            public void setLike_count(String like_count) {
                this.like_count = like_count;
            }

            public String getComment_count() {
                return comment_count;
            }

            public void setComment_count(String comment_count) {
                this.comment_count = comment_count;
            }

            public String getCan_comment() {
                return can_comment;
            }

            public void setCan_comment(String can_comment) {
                this.can_comment = can_comment;
            }

            public String getUnlike_enable() {
                return unlike_enable;
            }

            public void setUnlike_enable(String unlike_enable) {
                this.unlike_enable = unlike_enable;
            }

            public String getUnlike_count() {
                return unlike_count;
            }

            public void setUnlike_count(String unlike_count) {
                this.unlike_count = unlike_count;
            }

            public String getShare_count() {
                return share_count;
            }

            public void setShare_count(String share_count) {
                this.share_count = share_count;
            }

            public String getListorder() {
                return listorder;
            }

            public void setListorder(String listorder) {
                this.listorder = listorder;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getIs_gold() {
                return is_gold;
            }

            public void setIs_gold(String is_gold) {
                this.is_gold = is_gold;
            }

            public String getIs_redpack() {
                return is_redpack;
            }

            public void setIs_redpack(String is_redpack) {
                this.is_redpack = is_redpack;
            }

            public String getIs_ad() {
                return is_ad;
            }

            public void setIs_ad(String is_ad) {
                this.is_ad = is_ad;
            }

            public String getOpen_browser() {
                return open_browser;
            }

            public void setOpen_browser(String open_browser) {
                this.open_browser = open_browser;
            }

            public AdOtherMsgBean getAd_otherMsg() {
                return ad_otherMsg;
            }

            public void setAd_otherMsg(AdOtherMsgBean ad_otherMsg) {
                this.ad_otherMsg = ad_otherMsg;
            }

            public String getAd_type() {
                return ad_type;
            }

            public void setAd_type(String ad_type) {
                this.ad_type = ad_type;
            }

            public String getDisplay_type() {
                return display_type;
            }

            public void setDisplay_type(String display_type) {
                this.display_type = display_type;
            }

            public String getNews_stop_second() {
                return news_stop_second;
            }

            public void setNews_stop_second(String news_stop_second) {
                this.news_stop_second = news_stop_second;
            }

            public boolean isIs_liked() {
                return is_liked;
            }

            public void setIs_liked(boolean is_liked) {
                this.is_liked = is_liked;
            }

            public List<String> getCover_img() {
                return cover_img;
            }

            public void setCover_img(List<String> cover_img) {
                this.cover_img = cover_img;
            }

            @Override
            public int getItemType() {
                return type;
            }

            public static class AdOtherMsgBean {
                private List<?> imp;
                private List<?> clk;

                public List<?> getImp() {
                    return imp;
                }

                public void setImp(List<?> imp) {
                    this.imp = imp;
                }

                public List<?> getClk() {
                    return clk;
                }

                public void setClk(List<?> clk) {
                    this.clk = clk;
                }
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.id);
                dest.writeString(this.title);
                dest.writeString(this.href);
                dest.writeString(this.source);
                dest.writeString(this.keywords);
                dest.writeString(this.desc);
                dest.writeString(this.user_id);
                dest.writeString(this.cover_show_type);
                dest.writeString(this.author_avatar);
                dest.writeString(this.author_name);
                dest.writeString(this.uni);
                dest.writeString(this.language);
                dest.writeString(this.du_type);
                dest.writeString(this.create_time);
                dest.writeString(this.update_time);
                dest.writeString(this.channel);
                dest.writeString(this.type_id);
                dest.writeString(this.visit_count);
                dest.writeString(this.like_count);
                dest.writeString(this.comment_count);
                dest.writeString(this.can_comment);
                dest.writeString(this.unlike_enable);
                dest.writeString(this.unlike_count);
                dest.writeString(this.share_count);
                dest.writeString(this.listorder);
                dest.writeString(this.status);
                dest.writeString(this.is_gold);
                dest.writeString(this.is_redpack);
                dest.writeString(this.is_ad);
                dest.writeString(this.open_browser);
                dest.writeString(this.ad_type);
                dest.writeString(this.display_type);
                dest.writeString(this.news_stop_second);
                dest.writeByte(this.is_liked ? (byte) 1 : (byte) 0);
                dest.writeInt(this.type);
                dest.writeStringList(this.cover_img);
            }

            public DataBean() {
            }

            protected DataBean(Parcel in) {
                this.id = in.readString();
                this.title = in.readString();
                this.href = in.readString();
                this.source = in.readString();
                this.keywords = in.readString();
                this.desc = in.readString();
                this.user_id = in.readString();
                this.cover_show_type = in.readString();
                this.author_avatar = in.readString();
                this.author_name = in.readString();
                this.uni = in.readString();
                this.language = in.readString();
                this.du_type = in.readString();
                this.create_time = in.readString();
                this.update_time = in.readString();
                this.channel = in.readString();
                this.type_id = in.readString();
                this.visit_count = in.readString();
                this.like_count = in.readString();
                this.comment_count = in.readString();
                this.can_comment = in.readString();
                this.unlike_enable = in.readString();
                this.unlike_count = in.readString();
                this.share_count = in.readString();
                this.listorder = in.readString();
                this.status = in.readString();
                this.is_gold = in.readString();
                this.is_redpack = in.readString();
                this.is_ad = in.readString();
                this.open_browser = in.readString();
                this.ad_type = in.readString();
                this.display_type = in.readString();
                this.news_stop_second = in.readString();
                this.is_liked = in.readByte() != 0;
                this.type = in.readInt();
                this.cover_img = in.createStringArrayList();
            }

            public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
                @Override
                public DataBean createFromParcel(Parcel source) {
                    return new DataBean(source);
                }

                @Override
                public DataBean[] newArray(int size) {
                    return new DataBean[size];
                }
            };
        }
    }

    @Override
    public String toString() {
        return "NewsInfoResponse{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
