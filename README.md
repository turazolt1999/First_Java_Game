# The Peculiar Expedition - Java Kalandjáték

![image](https://user-images.githubusercontent.com/68961069/192540617-3caf35dd-8531-47e4-9a1d-702eaf77ef03.png) <br>

## Projekt Áttekintés
A **The Peculiar Expedition** egy egyjátékos kalandjáték, amelyet Java-ban fejlesztettek. A játékban egy felfedező bőrébe bújva egy veszélyes útra indulunk, hogy felfedezzük a rejtett kincseket és a legendás Arany Piramist. Az úton versenyeznünk kell rivális felfedezőkkel, hogy megszerezzük a legnagyobb kalandor címet, amelyet az öt expedíció során szerzett hírnév alapján ítélnek oda.

## Játék Jellemzők

### Alapjáték
- **Energia Kezelés**: Minden expedíciót 100 energiával és 250 arannyal kezdünk. Az energia a térképen való mozgással csökken, és étkezési tárgyak segítségével pótolható.
  
- **Innentárgy Kezelés**: A felfedezőnek 8 inventáriuma van, amelyek mindegyike legfeljebb 7 azonos tárgyat tartalmazhat (pl. 7 fáklya). Minél több tárgyat viszünk magunkkal, annál magasabbak a mozgási költségek, 20%-kal megnövelve minden további slot után.

- **Étel Tárgyak**: Az energia visszanyerésére fogyaszthatunk ételt:
  - **Gyümölcs**: +15 energia
  - **Hús**: +25 energia
  - **Csokoládé**: +20 energia
  - **Drogok**: +20 energia (addikció veszélye)
  - **Whiskey**: +20 energia (alkoholizmus veszélye)

- **Addikció Mechanika**: A drogok vagy whiskey rendszeres fogyasztása addikcióhoz vezethet. Ha az addiktív karakter nem kapja meg az adott tárgyat 30 lépésen belül, akkor minden lépésnél 10% eséllyel elhagyja a csapatot.

- **Parti Tagok**: Akár 3 kísérőt is toborozhatunk az expedícióink során. Minden kísérő növeli a mozgási költségeket 15%-kal. A kísérők közé tartoznak:
  - **Kereskedő**: Olcsóbban vásárolhatunk, drágábban eladhatunk.
  - **Katona**: A whiskey +20%-kal növeli az energiát.
  - **Szamár**: +2 inventárium slot.

- **Falvak**: A falvakban további kísérőket toborozhatunk, mint a **Felderítő**, **Sámán** vagy **Bölcs**, mindegyik 150 aranyba kerül, amennyiben jó kapcsolatban állunk a falvakkal.

### Térkép Felfedezése
A térkép különböző típusú terepeket tartalmaz, mint víz, hegyek, dzsungelek, barlangok és oltárok.

- Csak a térképen lévő olyan területeket láthatjuk, amelyek szomszédosak az aktuális helyünkkel, vagy amelyek már korábban felfedezésre kerültek.

- A mozgási költségek változhatnak a terep típusa és az inventoryban lévő tárgyak száma alapján.

### Katasztrófák és Átkozottságok
- **Katasztrófák**:
  - 20% esély, hogy egy csapattag megsérül (5%-os eséllyel elhagyja a csapatot minden egyes lépésnél, de regenerálódik az expedíciók között).
  - 10% esély, hogy egy csapattag azonnal elhagyja a csapatot.
  - 70% esély, hogy a csapat elveszít 45 energiát.

- **Átkozottságok**:
  - 35% esély vulkánkitörésre, amely közeli hegyeket vulkánná változtat, és lávát szór 4 lépésen keresztül.
  - 65% esély, hogy gejzírkitörés következik be, amely véglegesen vízzé változtatja a terepet.

### Expedíció Vége
Minden expedíció végén eldönthetjük, hogy eladjuk a kincseket aranyért, vagy átadjuk azokat egy múzeumnak a hírnév megszerzésére.

Versenyezhetünk 3 rivális felfedezővel, akik szintén hírnevet szereznek idővel. Az ő előrehaladásuk látható az expedíciók között.

### Fájl Alapú Térkép Betöltés
A játék támogatja a térképek betöltését fájlból. A fájlformátum rugalmas, minden egyes tereptípus számokkal van reprezentálva (pl. 1 a víz, 2 a hajó, 3 a tó, stb.).

## Implementációs Részletek

### Funkcionális Követelmények
- **Térkép Felfedezés**: A térkép vízből és szárazföldből áll, különböző tereptípusokkal, mint hegyek, dzsungelek és barlangok. A játékos csak a szomszédos vagy már felfedezett területeket látja.
  
- **Mozgás**: A játékos a térképen mozoghat, az energiafelhasználás a terep és az inventárium nagyságától függ. A játékos nem tud olyan területre lépni, amely átjárhatatlan (víz, tavak, hegyek).
  
- **Energia Kezelés**: Ha a játékos elfogy az energiája, a csapattagok elhagyhatják az expedíciót, és ha a felfedező egyedül marad, a játék elveszik.

- **Innentárgy Kezelés**: A játékos 8 inventárium hellyel rendelkezik, amelyeken legfeljebb 7 azonos tárgy fér el. Minél több tárgyat viszünk, annál magasabbak a mozgási költségek.

- **Étel Tárgyak**: Különböző ételtárgyak fogyaszthatók az energia visszanyerésére, néhány közülük addikcióval jár.

- **Parti Tagok**: A játékos különböző képességekkel rendelkező kísérőket toborozhat, például kereskedőket, katonákat és szamárokat.

- **Falvak**: A falvakban további kísérők toborozhatók, mint felderítők, sámánok vagy bölcsek.

- **Katasztrófák és Átkozottságok**: A játék katasztrófákat és átkozottságokat tartalmaz, amelyek hatással vannak a csoportra és a térképre.

- **Rivális Felfedezők**: A játék nyomon követi a rivális felfedezők hírnevét, akik versengenek a legnagyobb kalandor címért.

- **Fájl Alapú Térkép Betöltés**: A játék fájlokból betölthető térképeket használ, de nélküle is működik.

### Műszaki Követelmények
- **Osztály Struktúra**: A program legalább 5 jelentős osztályt tartalmaz, mindegyik a játék különböző entitásait reprezentálja (pl. Felfedező, Térkép, Inventárium stb.).
  
- **Csomagok**: Az osztályok funkciójuk szerint csomagokba vannak rendezve.

- **Öröklődés**: Legalább 2 osztály jelentős alosztályokkal rendelkezik.

- **Egység Elv**: Minden osztály egyetlen jól meghatározott feladatot lát el.

- **Kód Konvenciók**: Az osztályok, metódusok és változók nevei követik a Java névadási konvenciókat és tükrözik azok célját. A kód megfelelően van behúzva.

- **Metódus Hossza**: Egyetlen metódus sem haladja meg a 100 sort, és a legtöbb metódus 50 sor alatt van.

- **JavaDoc Dokumentáció**: A kód dokumentálva van JavaDoc-kal, amely magyarázza az egyes osztályok és legalább a metódusok 70%-át (kivéve a gettereket és settereket).

- **Bemeneti Érvényesítés**: A program megfelelően kezeli a hibás felhasználói bemeneteket, megelőzve a program összeomlását vagy váratlan viselkedést.

## Linkek
- [A Curious Expedition a Steam-en](https://store.steampowered.com/app/600790/The_Curious_Expedition/)
- [Játékmenet Videó](https://www.youtube.com/watch?v=some_video)

Ez a projekt egyetemi feladatként készült, és bemutatja az objektum-orientált programozás elveinek alkalmazását Java-ban egy összetett, interaktív játék létrehozására. A játék különböző mechanikákat tartalmaz, például inventárium kezelést, csapattag toborzást és térkép felfedezést, miközben rivális felfedezőkkel versenyezhetünk a hírnév és dicsőség elnyeréséért.
