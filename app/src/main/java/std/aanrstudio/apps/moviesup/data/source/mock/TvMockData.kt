package std.aanrstudio.apps.moviesup.data.source.mock

import std.aanrstudio.apps.moviesup.R
import std.aanrstudio.apps.moviesup.data.source.model.Tv

object TvMockData {
    private val title = arrayOf(
        "Arrow",
        "Dragon Ball",
        "Fairy Tail",
        "Family Guy",
        "The Flash",
        "Game of Thrones",
        "Gotham",
        "Naruto Shippuden",
        "Supergirl",
        "The Simpson"
    )

    private val overview = arrayOf(
        "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
        "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the dragon balls brought her to Goku\\'s home. Together, they set off to find all seven dragon balls in an adventure.",
        "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn\\'t just any ordinary kid, he\\'s a member of one of the world\\'s most infamous mage guilds: Fairy Tail.",
        "Sick, twisted, politically incorrect and Freakin\\' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he\\'s not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
        "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won\\'t be long before the world learns what Barry Allen has become...The Flash.",
        "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night\\'s Watch, is all that stands between the realms of men and icy horrors beyond.",
        "Everyone knows the name Commissioner Gordon. He is one of the crime world\\'s greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon\\'s story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world\\'s most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
        "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
        "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
        "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general."
    )

    private val duration = arrayOf(
        "42min",
        "26min",
        "25min",
        "22min",
        "44min",
        "60min",
        "43min, 60min",
        "22min",
        "42min",
        "22min"
    )

    private val poster = arrayOf(
        "/mo0FP1GxOFZT4UDde7RFDz5APXF.jpg",
        "/3wx3EAMtqnbSLhGG8NrqXriCUIQ.jpg",
        "/58GKcwFV3lpVOGzybeMrrNOjHpz.jpg",
        "/gBGUL1UTUNmdRQT8gA1LUV4yg39.jpg",
        "/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg",
        "/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
        "/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg",
        "/zAYRe2bJxpWTVrwwmBc00VFkAf4.jpg",
        "/4ka8vAzAFUZFKxWyfGfwVcSXuZo.jpg",
        "/yTZQkSsxUFJZJe67IenRM0AEklc.jpg"
    )

    val mockData: ArrayList<Tv>
        get() {
            val ls = arrayListOf<Tv>()
            for (position in title.indices) {
                val tv = Tv()
                tv.title = title[position]
                tv.overview = overview[position]
                tv.duration = duration[position]
                tv.poster = poster[position]
                ls.add(tv)
            }
            return ls
        }

}