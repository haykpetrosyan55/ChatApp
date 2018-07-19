package com.example.hp.chatapp;

import com.example.hp.chatapp.models.MessageModel;
import com.example.hp.chatapp.models.UserModel;

import java.util.ArrayList;

public class ChatProvider {
    private static ArrayList<UserModel> userList = new ArrayList<>();

    public static ArrayList<UserModel> getUserProvider() {
        if (!userList.isEmpty()) {
            userList.clear();
        }

        userList.add(new UserModel("IronMan", "https://spiderimg.amarujala.com/assets/images/2018/05/10/750x506/hollywood_1525936416.jpeg", "055111111", "www.hayk55555@list.ru", "Железный человек; настоящее имя — Энтони Эдвард «Тони» Старк — персонаж, изданий Marvel Comics и их адаптаций, созданный писателем Стэном Ли, сценаристом Ларри Либером и художниками Доном Хэком и Джеком Кёрби", new ArrayList<MessageModel>()));
        userList.add(new UserModel("Halk", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRw8yh99cgL7mU0dGWRLq47OpJiXdZQLOVJnHZLc5mhR9IYgdn05g", "055222222", "www.Halk.ru", "«Халк» — фантастический боевик режиссёра Энга Ли, снятый по одноимённым комиксам Marvel Comics об учёном, который в приступе ярости может превращаться в зелёное чудовище. Слоган фильма «Unleash the fury».", new ArrayList<MessageModel>()));
        userList.add(new UserModel("Thor", "https://s1-ssl.dmcdn.net/pHLu7/x480-k5-.jpg", "055333333", "www.Thor.com", "«Тор» — художественный фильм режиссёра Кеннета Брана, основанный на одноимённых комиксах издательства Marvel Comics. Созданием картины занималась компания Marvel Studios, а распространением Paramount Pictures.", new ArrayList<MessageModel>()));
        userList.add(new UserModel("Batman", "http://www.konbini.com/wp-content/blogs.dir/3/files/2016/10/batman.jpg", "055444444", "www.Batman.com", "Бэтмен, изначально Бэт-мен — вымышленный персонаж, супергерой, персонаж комиксов издательства DC Comics, впервые появившийся в Detective Comics № 27 в мае 1939 года.", new ArrayList<MessageModel>()));
        userList.add(new UserModel("Captain America", "https://images-na.ssl-images-amazon.com/images/I/51l7kcya9dL._SX425_.jpg", "055555555", "www.CaptainAmerica.com", "Капита́н Америка — вымышленный персонаж супергерой комиксов издательства Marvel Comics. Он был создан писателем Джо Саймоном и художником Джеком Кирби и впервые появился в комиксах 1940-х", new ArrayList<MessageModel>()));
        userList.add(new UserModel("Daisy Quake", "https://sm.ign.com/ign_latam/news/a/agents-of-/agents-of-shield-first-photo-of-chloe-bennet-in-he_7nd2.jpg", "055666666", "www.DaisyQuake.com", "Дейзи Джонсон, также известная как Дрожь — персонаж, супергероиня комиксов, публикуемых издательством «Marvel Comics», агент, а позже — директор организации Щ.И.Т. ", new ArrayList<MessageModel>()));
        userList.add(new UserModel("Ghost Rider", "https://1.bp.blogspot.com/-FVEAMWI7HDc/WIZ5Z7BO3vI/AAAAAAAAI1c/YfE1rkoeAbsctirNjJhoZ4tQjz-zubvKACLcB/s320/thumbnail_FB_IMG_1444399045280.jpg", "055777777", "www.GhostRider.com", "«Призрачный гонщик» — фильм 2007 года, основанный на истории о персонаже «Призрачный гонщик» из вселенной Marvel Comics. В роли гонщика снялся Николас Кейдж, а также снялись Ева Мендес, ", new ArrayList<MessageModel>()));
        userList.add(new UserModel("Infinity War", "http://paperlief.com/images/black-widow-marvel-movie-wallpaper-3.jpg", "055888888", "www.InfinityWar.com", "Пока Мстители и их союзники продолжают защищать мир от различных опасностей, с которыми не смог бы справиться один супергерой, новая угроза возникает из космоса: Танос. ", new ArrayList<MessageModel>()));
        userList.add(new UserModel("Harley Quinn", "http://wallpapermad.com/wp-content/uploads/2017/07/MARGOT-ROBBIE-HARLEY-QUINN-SUICIDE-SQUAD-wallpaper-wp3208330.jpg", "055999999", "www.HarleyQuinn.com", "Харли Квинн — вымышленный персонаж, суперзлодейка вселенной DC Comics, первоначально появившаяся в мультсериале «Бэтмен» 1992 года,", new ArrayList<MessageModel>()));
        userList.add(new UserModel("Jocker", "https://i.ytimg.com/vi/ojg_LVcZVxM/maxresdefault.jpg", "055101010", "www.Jocker.com", "Джокер — суперзлодей вселенной DC Comics, главный и заклятый враг Бэтмена. Джокер носит фиолетовый костюм и сражается при помощи предметов, которые стилизованы под реквизит клоуна и иллюзиониста", new ArrayList<MessageModel>()));
        userList.add(new UserModel("Logan", "https://avatars.mds.yandex.net/get-zen_doc/57035/pub_5abff03f55876b8b1c409b06_5abffbcb48267788694d4c69/scale_600", "055011011", "www.Logan.com", "В недалеком будущем уставший от жизни Логан заботится о больном профессоре Икс, который прячется неподалеку от мексиканской границы. Но Логан больше не сможет скрывать свое прошлое, когда встретится с юным мутантом", new ArrayList<MessageModel>()));
        userList.add(new UserModel("Spider Man", "https://i.pinimg.com/originals/b8/1c/25/b81c25b8ebf37b2e22339ab198d3c7ea.jpg", "055012012", "www.SpiderMan.com", "Челове́к-пау́к, настоящее имя Пи́тер Па́ркер — персонаж, супергерой, появляющийся в комиксах издательства Marvel Comics, созданный Стэном Ли и Стивом Дитко", new ArrayList<MessageModel>()));
        userList.add(new UserModel("Valkiria", "https://i.pinimg.com/originals/b3/59/68/b359684bce8d8a7ecb31fd5d5d1bf8e3.jpg", "055013013", "www.Valkiria.com", "Валькирия, также известная под своим настоящим именем Брунгильда — персонаж комиксов издательства Marvel Comics,", new ArrayList<MessageModel>()));
        userList.add(new UserModel("Phil Coulson", "http://moviemagazine.it/wp-content/uploads/2018/03/Phil-Coulson-5.jpeg", "055014014", "www.PhilCoulson.com", "Филлип Коулсон — вымышленный персонаж кинематографической вселенной Marvel, включающей в себя несколько фильмов о супергероях издательства Marvel Comics", new ArrayList<MessageModel>()));

        return userList;
    }

    public static UserModel getUserPosition(int position) {
        return userList.get(position);
    }
}