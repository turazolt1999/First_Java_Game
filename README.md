# The-Peculiar-Expedition-First-Java-Game-
![image](https://user-images.githubusercontent.com/68961069/192540617-3caf35dd-8531-47e4-9a1d-702eaf77ef03.png) <br>
A feladat egy egyszemélyes játék megvalósítása Java 
nyelven. A játékban felfedezőt kell alakítanunk, aki hajóra száll 
és veszedelmes tájakon igyekszik összegyűjteni az ott elrejtett 
kincseket és a legendás Arany piramist! A felfedező sajnos 
nincs egyedül, más felfedezőkkel kell versengenie a legjobb 
felfedező címéért, amelyet 5 küldetés után a legtöbb hírnévvel 
rendelkező felfedező kap. <br>
A felfedező minden térkép elején 100 energiával
(amely a maximum) és 250 arannyal indul, amelyet a 
küldetések között elkölthet:

• élelmiszerekre, amelyek véges számban rendelkezésre állnak a kikötőben<br>
• egyéb tárgyakra vagy társakra.<br>
A játékos csak bizonyos számú tárgyat vihet magával a terepen, ezeket inventory slot-okon tároljuk. 
Minden felfedező 8 slottal rendelkezik. Ha ennél több van nála, akkor minden mozgás költség plusz 
slotonként +20%-kal növekszik. Egy slotra csak azonos tárgyak kerülhetnek, egy tárgyból 7 darab 
ugyanolyan (pl. 7 fáklya), ennél több új slotra kerül. Kincsekből csak egy lehet egy sloton.
Az energiát fel lehet tölteni különböző élelmiszerek fogyasztásával, ilyenek Gyümölcs +15, 
Hús +25, Csokoládé +20, Kábítószer +20, Whiskey +20. Amennyiben az utolsó két fogyasztott 
élelmiszer Whiskey, minden Whiskey fogyasztásnál 15% eséllyel egy csapattárs vagy a felfedező 
alkoholista lesz, illetve a kábítószer ugyanígy függőséget okoz. Függőségnél, ha az utóbbi 30 
lépésben nem kapott az alany a kiváltó élelmiszerből, akkor lépésenként 10% eséllyel elhagyja a 
csapatot. Amennyiben az energia elfogy, minden csapattag lépésenként 8% eséllyel elhagyhatja a 
csapatot. A felfedező ilyenkor csak akkor hagyja el a csapatot, ha már csak egyedül van. Ilyen 
esetben a játékos veszít. Pihenéskor az energia visszatöltődik 100-ra.<br>
Minden küldetés előtt ajánl a játék egy csapattársat, amelyet vagy felveszünk, vagy nem, 
ezek lehetnek: Kereskedő (mindent kicsivel olcsóbban vehetünk és drágábban adhatunk el), 
Katona (a Whiskey +20% energia), Szamár (+2 Inventory slot). A térképen falvakkal is 
találkozhatunk, ahol legalább 2 viszony esetén 20%-os eséllyel ajánlanak nekünk egy Felderítőt
(+1 látókör), Sámánt (a Kábítószer +20% energia) vagy Bölcset (+3 alapviszony új térképen). Egy 
új csapattárs felvétele mindig 150 aranyba kerül, egyszerre maximum 3 csapattársunk lehet. Minden 
új csapattárs 15%-kal növeli a mozgás energiaköltségét. Minden pályán 3 viszonnyal indulunk, a 
viszony nem falunként, hanem a teljes pályára értelmezendő.


Valami kis változatatás!