# Welt der Harmonie:

## Das Abschlussprojekt zum Modul "Grundlagen der Programmierung" des Synthax Instituts

Willkommen zum Spiel "Welt der Harmonie", das als Abschlussprojekt im Rahmen des Kurses am Synthax Institut entwickelt
wurde.




<details>
  <summary>Die Geschichte von "Welt der Harmonie"</summary>

In der Welt der Harmonie, wo Gleichgewicht und Frieden durch das feine Geflecht magischer Energien aufrechterhalten
wurden, herrschte einst stetige Ruhe. Doch diese Ruhe wurde gestört, als aus einer anderen Dimension eine Kreatur namens
YinYangXian, die Personifikation der Unordnung, einbrach.

YinYangXian brachte Verwerfung und zielte darauf ab, die harmonischen Bindungen zu zerschneiden, die die Realitäten
zusammenhielten. Die Erde begann zu verderben, die Meere tobten wild, und die Kreaturen der Welt litten zunehmend unter
der wachsenden Disharmonie.

Drei ungleiche Helden standen auf, um der wachsenden Dunkelheit entgegenzutreten: der weise Magier Zhen, dessen Zauber
das Licht der Ordnung beschwören konnte; die kühne Schamanin Xiaoli, die mit den Geistern der Natur sprach und deren
Heilzauber die Wunden der Verzweifelten heilte; und der kluge Geomancer Lian, dessen Macht über die Erde selbst die
chaotischen Energien zu bändigen vermochte.

Zusammen begaben sie sich auf eine gefahrvolle Reise, um YinYangXian entgegenzutreten und die Harmonie in ihre Welt
zurückzuführen. Auf Schlachtfeldern, die sich über verschlungene Dimensionen erstreckten, setzten sie ihre einzigartigen
Kräfte ein, um die Schergen des Chaos zu besiegen und die Ordnung wiederherzustellen.

Die Reise war hart und die Schlachten waren grauenvoll, aber mit jedem errungenen Sieg leuchtete das Licht der Harmonie
immer stärker. Die Frage, die nun in der Luft liegt: Werden Zhen, Xiaoli und Lian es schaffen, YinYangXian zu überwinden
und ihre Welt zu retten? Tauche ein in "Welt der Harmonie" und erlebe ihr Schicksal.

</details>


<details>
  <summary>Klassendiagramm "Welt der Harmonie"</summary>

Das Klassendiagramm für das Projekt kann hier eingesehen werden:

[![Class-Diagram-Template-Community.png](https://i.postimg.cc/tgyVGPgn/Class-Diagram-Template-Community.png)](https://postimg.cc/68jQd8nB)
</details>

---

<details>
  <summary>Cultivator-Klasse (Abstrakte Heldenvorlage)</summary>

Die `Cultivator`-Klasse ist eine abstrakte Basisklasse, die die Grundlage für alle Helden im Spiel "Welt der Harmonie" bildet. Sie definiert die allgemeinen Eigenschaften und Fähigkeiten, die von allen spezifischen Heldenklassen geteilt und angepasst werden.

### Grundlegende Attribute:

- `name`: Eindeutiger Name des Helden.
- `healthPoints`: Gesundheitspunkte des Helden, die seine Widerstandsfähigkeit im Kampf bestimmen.
- `actions`: Eine Liste von Aktionen, die der Held ausführen kann.
- `defenseValue`: Verteidigungswert des Helden, welcher die Effektivität der Verteidigung bestimmt.

### Kernfunktionen:

- `attack(opponent: Enemy)`: Greift einen Gegner an, wobei der Schaden zufällig innerhalb eines bestimmten Bereichs berechnet wird.
- `defend(cultivator: Cultivator)`: Aktiviert die Verteidigung des Helden, um den eingehenden Schaden zu reduzieren.
- `heal(cultivator: Cultivator)`: Heilt einen anderen Helden oder sich selbst, um die Gesundheitspunkte zu erhöhen.
- `specialAction(enemy: Enemy)`: Führt eine spezielle und oft mächtigere Aktion aus, die zusätzliche Effekte haben kann.

### Erweiterte Heilmethoden:

Die Methode `heal(cultivator: Cultivator, enemy: Enemy)` ist in der Basisklasse als Vorlage ohne spezifische Implementierung definiert. Sie bietet die Möglichkeit für Unterklassen, individuelle Heil- oder Schadensmechaniken zu entwickeln, die gleichzeitig Verbündete heilen und Feinden Schaden zufügen können.

- Diese Methode sollte in den spezifischen Heldenklassen überschrieben werden, um die gewünschten Effekte zu erzielen.
- Sie erlaubt es Helden, kreative Aktionen auszuführen, die das Schlachtfeld dynamisch beeinflussen können.

Die `Cultivator`-Klasse dient als Bauplan für die Erstellung spezifischer Heldencharaktere und bietet eine flexible Struktur, um das Verhalten und die Fähigkeiten der Helden zu definieren.

</details>



<details>
  <summary>TaoistMage-Klasse</summary>

Die `TaoistMage`-Klasse repräsentiert einen spezifischen Heldentyp im Spiel "Welt der Harmonie", der sich auf magische
Angriffe und Verteidigung spezialisiert hat. Diese Klasse erbt von der abstrakten Basisklasse `Cultivator` und fügt
zusätzliche Funktionalitäten hinzu, die spezifisch für einen Zauberwirker sind.

### Attribute:

- `spellPower: Int` (privat) - Die Stärke der Zauberkraft des TaoistMage, die den Schaden seiner magischen Angriffe
  beeinflusst.

### Konstruktor:

- `TaoistMage(name: String, healthPoints: Int, actions: MutableList<Action>, spellPower: Int)` - Initialisiert einen
  neuen TaoistMage mit Namen, Gesundheitspunkten, einer Liste von Aktionen und Zauberkraft.

### Überschriebene Methoden:

- `attack(opponent: Enemy)` - Der TaoistMage führt einen mächtigen Zauberangriff wie "Feuersturm" aus, der erheblichen
  Schaden verursacht, jedoch auch seine eigene Verteidigung nach dem Angriff reduziert.
- `defend(cultivator: Cultivator)` - Statt sich selbst zu verteidigen, kann der TaoistMage einen Verteidigungszauber
  verwenden, um die Verteidigung eines anderen Helden zu erhöhen.
- `heal(cultivator: Cultivator)` - Heilt einen anderen Helden um einen festgelegten Betrag, was die Überlebenschancen
  des Teams erhöht.
- `specialAction(enemy: Enemy)` - Der TaoistMage kann eine spezielle Aktion ausführen, die den Schadenswert des nächsten
  Angriffs erhöht, dafür aber eigene Lebenspunkte opfert. Dies ist eine riskante, aber möglicherweise spielentscheidende
  Fähigkeit.

### Zusätzliche Methoden:

- `toString(): String` - Gibt eine String-Repräsentation des TaoistMage zurück, die nützlich ist, um den Zustand des
  Objekts während der Entwicklung und des Debuggings zu überprüfen.

Diese Klasse stellt eine der Schlüsselfiguren im Spiel dar und bietet eine Kombination aus Offensiv- und
Unterstützungsfähigkeiten, die im Kampf gegen die Kräfte der Unordnung eingesetzt werden können.

</details>

<details>
  <summary>Shaman-Klasse</summary>

Die `Shaman`-Klasse stellt einen Schamanen dar, einen spezialisierten Heldentyp im Spiel "Welt der Harmonie", der
Heilung und Unterstützungszauber beherrscht. Diese Klasse erbt von `Cultivator` und erweitert dessen Funktionalität um
schamanenspezifische Fähigkeiten.

### Attribute:

- `healingPower: Int` (privat) - Bestimmt die Stärke der Heilfähigkeiten des Schamanen und beeinflusst die Menge der
  Heilung, die er leisten kann.

### Konstruktor:

- `Shaman(name: String, healthPoints: Int, actions: MutableList<Action>, healingPower: Int)` - Initialisiert einen neuen
  Schamanen mit einem Namen, Gesundheitspunkten, einer Liste von Aktionen und Heilkräften.

### Überschriebene Methoden:

- `heal(cultivator: Cultivator)` - Heilt einen anderen Helden um einen Betrag, der der Heilkraft des Schamanen
  entspricht, und ist entscheidend, um das Überleben des Teams im Kampf zu sichern.
- `defend(cultivator: Cultivator)` - Erhöht die Verteidigung eines anderen Helden, um diesen widerstandsfähiger gegen
  Angriffe zu machen.
- `attack(opponent: Enemy)` - Führt einen Flächenzauber aus, der allen Feinden Schaden zufügt und besonders nützlich
  ist, um mehrere Gegner gleichzeitig zu treffen.
- `specialAction(enemy: Enemy)` - Führt eine mächtige spezielle Aktion aus, die einem einzelnen Gegner großen Schaden
  zufügt, was in kritischen Kampfsituationen von Vorteil sein kann.

Die `Shaman`-Klasse ist eine Schlüsselfigur im Kampf gegen die Kräfte der Unordnung und bietet eine Kombination aus
Heilung und offensiven Fähigkeiten, um das Team zu unterstützen und die Gegner zu besiegen.

</details>


<details>
  <summary>Geomancer-Klasse</summary>

Die `Geomancer`-Klasse verkörpert einen Geomanten, einen spezialisierten Heldentyp im Spiel "Welt der Harmonie", der
Erd- und Elementarkräfte beherrscht. Er erweitert die Fähigkeiten der abstrakten `Cultivator`-Basisklasse um
geospezifische Aktionen.

### Attribute:

- `earthPower: Int` (privat) - Bestimmt die Stärke der Erdkräfte des Geomanten und beeinflusst spezielle Aktionen wie
  Erdbebenangriffe.
- `elementalPower: Int` (privat) - Bestimmt die Stärke der Elementarkräfte des Geomanten und beeinflusst den Schaden
  einiger magischer Angriffe.

### Konstruktor:

- `Geomancer(name: String, healthPoints: Int, actions: MutableList<Action>, earthPower: Int, elementalPower: Int)` -
  Initialisiert einen neuen Geomanten mit einem Namen, Gesundheitspunkten, einer Liste von Aktionen, Erdkraft und

- Elementarkraft.

### Überschriebene Methoden:

- `defend(cultivator: Cultivator)` - Der Geomant kann eine Erdwand erschaffen, um die Verteidigung eines anderen Helden
  zu erhöhen und das Team vor starken Angriffen zu schützen.
- `attack(opponent: Enemy)` - Der Geomant führt einen Elementarzauber aus, der allen Feinden Schaden zufügt und
  besonders effektiv ist, um mehrere Gegner gleichzeitig zu attackieren.
- `specialAction(enemy: Enemy)` - Ein mächtiger Erdbebenangriff kann einen einzelnen Gegner erheblich schädigen und ist
  in entscheidenden Kampfmomenten einsetzbar.
- `heal(cultivator: Cultivator, enemy: Enemy)` - Der Geomant kann einem Gegner Energie entziehen und sich selbst um den
  gleichen Betrag heilen, was die eigene Gesundheit erhält und dem Gegner gleichzeitig schadet.

Die `Geomancer`-Klasse ist essenziell für die strategische Tiefe des Spiels und bietet vielfältige Möglichkeiten, die
Kräfte der Natur im Kampf gegen die Mächte der Unordnung einzusetzen.

</details>

---

<details>
  <summary>Enemy-Klasse</summary>

Die `Enemy`-Klasse ist eine Basisklasse für alle Gegner im Spiel "Welt der Harmonie". Sie definiert allgemeine Eigenschaften und Verhaltensweisen, die von allen Gegnertypen geteilt werden und legt die Grundlage für das Verhalten der Gegner im Spiel.

### Attribute:

- `name: String` - Der Name des Gegners, der ihn im Spiel identifiziert.
- `healthPoints: Int` - Die Gesundheitspunkte des Gegners, die bestimmen, wie viel Schaden er nehmen kann, bevor er besiegt wird. Kann nicht unter Null fallen.
- `actions: MutableList<Action>` - Eine modifizierbare Liste von Aktionen, die den Gegner befähigen, verschiedene Angriffe und Fähigkeiten auszuführen.
- `defensePower: Int` - Die Verteidigungskraft des Gegners, ein Wert, der den Schaden reduziert, den der Gegner von eingehenden Angriffen erhält.

### Methoden:

- `attack(cultivators: List<Cultivator>, name: String, minDamage: Int, maxDamage: Int)` - Greift eine Liste von Kultivatoren mit einem Angriff an, dessen Schaden zwischen einem Mindest- und Höchstwert zufällig gewählt wird. Die Verteidigungswerte der Kultivatoren werden dabei berücksichtigt.
- `specialAction(targets: Cultivator)` - Führt eine Spezialaktion aus, die in Unterklassen überschrieben werden sollte, um spezifische Fähigkeiten oder Angriffe zu ermöglichen.
- `heal()` - Heilt sich selbst um einen festgelegten Betrag. Dies erhöht die Überlebensfähigkeit des Gegners im Kampf.
- `defend(enemy: Enemy)` - Erhöht die Verteidigungskraft des Gegners selbst, um ihn resistenter gegen Angriffe zu machen.

Die `Enemy`-Klasse dient als Vorlage für verschiedene Gegnertypen und kann durch Vererbung angepasst werden, um spezifischere und komplexere Verhaltensmuster für unterschiedliche Gegner zu schaffen.

</details>


<details>
  <summary>DualisticDemon-Klasse</summary>

Die `DualisticDemon`-Klasse verkörpert den Endgegner im Spiel "Welt der Harmonie". Als eine besondere Form des Gegners (`Enemy`) besitzt er einzigartige Angriffs- und Verteidigungsaktionen, die ihm helfen, das Chaos im Spiel zu verbreiten und für die Spieler eine große Herausforderung darzustellen.

### Eigenschaften:
- `name: String` - Der Name des Dämons, "YinYangXian".
- `healthPoints: Int` - Die Gesundheitspunkte, mit denen der Dämon startet, standardmäßig auf 150 gesetzt.
- `actions: MutableList<Action>` - Eine Liste von Aktionen, die der Dämon ausführen kann, einschließlich Angriffe und spezielle Fähigkeiten.

### Konstruktor und Companion-Objekt:
- Der Konstruktor ist privat, um die Singleton-Natur dieser Klasse zu gewährleisten. Dadurch wird sichergestellt, dass es nur eine Instanz des `DualisticDemon` im Spiel gibt, zugänglich durch die `getInstance()` Methode im Companion-Objekt.

### Überschriebene Methoden:
- `specialAction(targets: Cultivator)` - Führt einen speziellen Angriff aus, der zufälligen Schaden verursacht, basierend auf einem Zufallswert, multipliziert mit 5. Diese Methode ist besonders effektiv gegen einzelne Ziele und spiegelt die chaotische Natur des Dämons wider.
- `heal()` - Heilt den `DualisticDemon` um einen zufälligen Betrag zwischen 10 und 20, was seine Fähigkeit, im Kampf zu überleben, erheblich erhöht.
- `defend(enemy: Enemy)` - Erhöht die eigene Verteidigungskraft um 5, was den Dämon widerstandsfähiger gegen Angriffe macht. Diese Methode zeigt seine Fähigkeit, sich selbst zu stärken und seine Verteidigung zu erhöhen.

### Singleton-Implementierung:
- `getInstance(): DualisticDemon` - Diese Methode garantiert, dass nur eine einzige Instanz des `DualisticDemon` existiert. Die Instanz wird bei der ersten Verwendung erstellt und für nachfolgende Zugriffe wiederverwendet.

Die `DualisticDemon`-Klasse ist ein zentraler Antagonist in der Geschichte von "Welt der Harmonie" und bietet den Spielern durch ihre komplexen Angriffe und Heilfähigkeiten eine anspruchsvolle Herausforderung.

</details>


<details>
  <summary>DualMinion-Klasse</summary>

Die `DualMinion`-Klasse stellt einen Unterstützungsgegner im Spiel "Welt der Harmonie" dar. Als treuer Diener des mächtigen DualisticDemon hat er die Aufgabe, seinen Meister im Kampf zu unterstützen und zu heilen.

### Singleton-Design:
Die Klasse verwendet das Singleton-Designmuster, um sicherzustellen, dass nur eine Instanz des DualMinion im Spiel existieren kann. Dies gewährleistet eine konsistente Spiellogik und verhindert, dass mehrere Instanzen desselben Unterbosses gleichzeitig aktiv sind.

### Methoden:
- `heal()`: Eine spezielle Methode des DualMinion, die den DualisticDemon heilt und somit die Langlebigkeit des Hauptgegners im Kampf erhöht.

### Companion-Objekt:
- `getInstance()`: Eine Methode, die den Zugriff auf die Singleton-Instanz des DualMinion ermöglicht. Wenn noch keine Instanz existiert, wird sie durch Aufruf der `initialize()`-Methode erstellt.

Die `DualMinion`-Klasse ist ein wichtiger Bestandteil der Gegnerhierarchie im Spiel und trägt zur Tiefe und Komplexität der Spielmechanik bei.

</details>

---

<details>
  <summary>Item-Klasse</summary>

Die `Item`-Klasse repräsentiert verschiedene Gegenstände im Spiel "Welt der Harmonie", die von Charakteren verwendet
werden können, um verschiedene Boni oder Heilwirkungen zu erzielen.

### Attribute:

- `name: String` - Der Name des Gegenstandes, der seinen Typ und seine Wirkung identifiziert.
- `quantity: Int` - Die Menge des Gegenstandes, die dem Inventar des Spielers zur Verfügung steht.

### Methoden:

- `use(target: Cultivator): String` - Diese Methode wird aufgerufen, wenn ein Gegenstand auf einen Charakter angewendet
  wird. Sie gibt eine Beschreibung des Effekts zurück, der durch die Verwendung des Gegenstandes erzielt wurde. Die
  Methode verwendet eine `when`-Klausel, um den Namen des Gegenstandes zu überprüfen und den entsprechenden Effekt
  anzuwenden:
  - `"Himmelsstab"` - Verstärkt die Energie des Ziels.
  - `"Yin Yang Ring"` - Erhöht den Schadenswert des Ziels.
  - `"Qi-Harmonisation"` - Erhöht den Verteidigungswert des Ziels.
  - `"Drachenperle"` - Heilt das Ziel um einen festgelegten Betrag.
  - `"Sonnenstein"` - Verstärkt die Energie des Ziels.
  - `"Jadeamulett"` - Erhöht temporär die Verteidigungskraft des Ziels.
  - `"Donnersegen"` - Erhöht den Schadenswert des Ziels signifikant.
  - Bei unbekannten Gegenständen wird eine Nachricht zurückgegeben, dass der Gegenstand nicht bekannt ist.

Die `Item`-Klasse ist ein zentrales Element im Spiel, das den Spielern ermöglicht, ihre Strategie zu verfeinern und ihre
Charaktere entsprechend den Herausforderungen, die sie im Spiel treffen, anzupassen.

</details>


<details>
  <summary>Bag-Klasse</summary>

Die `Bag`-Klasse dient als Inventarsystem im Spiel "Welt der Harmonie". Sie ermöglicht das Speichern und Verwalten von
Gegenständen, die Charaktere während ihres Abenteuers sammeln und verwenden.

### Attribute:

- `items: MutableList<Item>` - Eine dynamische Liste, die die Gegenstände im Inventar des Spielers hält. Jeder
  Gegenstand ist ein Objekt der `Item`-Klasse.

### Methoden:

- `addItem(item: Item, quantityToAdd: Int = 1)` - Diese Methode fügt einen Gegenstand zum Inventar hinzu oder erhöht die
  Menge eines bereits vorhandenen Gegenstandes. Wenn ein Gegenstand neu hinzugefügt wird, wird seine Anfangsmenge
  auf `quantityToAdd` gesetzt, andernfalls wird seine Menge um `quantityToAdd` erhöht.
- `removeItem(chosenItem: Item)` - Entfernt einen Gegenstand aus dem Inventar, indem die Menge des Gegenstandes
  verringert wird. Wenn die Menge des Gegenstandes nach der Verringerung 0 erreicht, wird der Gegenstand komplett aus
  dem Inventar entfernt.

Die `Bag`-Klasse spielt eine wesentliche Rolle im Spiel, da sie den Spielern ermöglicht, Ressourcen zu sammeln und
strategisch einzusetzen, um ihre Chancen auf Erfolg im Spiel zu verbessern.

</details>

---

<details>
  <summary>Action-Klasse</summary>

Die `Action`-Klasse bildet das Fundament für alle Aktionen, die innerhalb des Spiels "Welt der Harmonie" von Charakteren
ausgeführt werden können. Aktionen umfassen ein breites Spektrum an Verhaltensweisen, darunter offensive Angriffe,
defensive Manöver und spezielle Fähigkeiten.

### Attribute:

- `name: String` - Der Name der Aktion, der beschreibt, was die Aktion bewirkt oder suggeriert.
- `type: String` - Der Typ der Aktion, der bestimmt, in welcher Kategorie die Aktion fällt. Typen können "Angriff","
  Verteidigung", "Spezialaktion" und andere kategorische Bezeichnungen sein.

### Methoden:

- `toString(): String` - Eine überschriebene Methode der `Any`-Klasse, die eine String-Repräsentation der Aktion
  zurückgibt. Dies ist besonders nützlich für das Debugging und für die Anzeige der Aktion in der Benutzeroberfläche des
  Spiels. Wenn die Aktion beispielsweise in einem Menü oder in einer Statusmeldung angezeigt wird, liefert `toString()`
  den Namen der Aktion als lesbaren Text.

Die `Action`-Klasse ermöglicht eine flexible Gestaltung des Spielverhaltens und unterstützt die Entwicklung eines
erweiterbaren Kampfsystems, in dem neue Aktionstypen leicht hinzugefügt und integriert werden können.

</details>

---

<details>
  <summary>CombatSystem-Klasse</summary>

Die `CombatSystem`-Klasse ist das Herzstück des Kampfmechanismus im Spiel "Welt der Harmonie". Sie verwaltet die Abläufe der Kampfrunden und steuert die Interaktionen zwischen den Kultivatoren und den Gegnern.

### Konstruktor:

- `CombatSystem(taoistSect: List<Cultivator>, bag: Bag)` - Initialisiert das Kampfsystem mit einer Gruppe von Kultivatoren und einem Inventar von Gegenständen, die im Kampf verwendet werden können.

### Private Attribute:

- `minionSummoned: Boolean` - Ein Flag, das anzeigt, ob der Unterboss bereits beschworen wurde.
- `activeEnemy: Enemy` - Der aktuell im Kampf aktive Gegner, initialisiert als `DualisticDemon`.

### Öffentliche Methoden:

- `executeRound(): Boolean` - Führt eine vollständige Kampfrunde aus und gibt zurück, ob der Kampf fortgesetzt werden soll.

### Private Hilfsmethoden:

- `checkEnemyStatus(): Boolean` - Überprüft die Gesundheit des aktiven Gegners und entscheidet über das Beschwören des Unterbosses oder die Rückkehr des Endgegners.
- `chooseBagOrAction(cultivator: Cultivator, itemUsedThisRound: Boolean): Boolean` - Lässt den Spieler zwischen dem Einsatz eines Gegenstandes oder einer Aktion wählen.
- `chooseItem(cultivator: Cultivator)` - Ermöglicht dem Spieler, einen Gegenstand aus dem Inventar auszuwählen und zu verwenden.
- `executeCultivatorAction(cultivator: Cultivator, action: Action, enemy: Enemy)` - Führt die vom Spieler ausgewählte Aktion eines Kultivators aus.
- `executeEnemyAction(enemy: Enemy, cultivators: List<Cultivator>, randomAction: Action)` - Führt eine Aktion des Gegners aus, basierend auf einer zufälligen Auswahl.
- `dualisticDemonActions(randomAction: Action, enemy: DualisticDemon, cultivators: List<Cultivator>)` - Führt Aktionen des `Dualistic Demon` aus.
- `dualMinionActions(randomAction: Action, enemy: Enemy, cultivators: List<Cultivator>)` - Führt Aktionen des `Dual Minion` aus.
- `chooseAction(cultivator: Cultivator): Action` - Ermöglicht die Auswahl einer Aktion für den Kultivator.
- `reportRound()` - Gibt einen Bericht über den aktuellen Stand des Kampfes.
- `isBattleOver(): Boolean` - Überprüft, ob der Kampf vorbei ist.
- `endOfTheBattle()` - Beendet den Kampf und verkündet das Ergebnis.
- `summonMinion()` - Beschwört den Unterboss `Dual Minion`.
- `summonDualisticDemon()` - Kehrt zum Kampf mit dem `Dualistic Demon` zurück, nachdem der `Dual Minion` besiegt wurde.

Diese Klasse ermöglicht es den Spielern, durch die Kampfrunden zu navigieren, strategische Entscheidungen zu treffen und den Fortschritt ihres Kampfes gegen die Gegner zu verfolgen. Die Klasse unterstützt die Schaffung eines dynamischen und interaktiven Kampferlebnisses.

</details>



<details>
  <summary>main.kt - Hauptspiellogik</summary>

Die `main.kt`-Datei beinhaltet die `main()`-Funktion, die als Einstiegspunkt für das Spiel "Welt der Harmonie" dient. Diese Funktion ist zuständig für die Initialisierung der Spielumgebung und die Steuerung des Kampfzyklus.

### Hauptfunktion `main`:

- Initialisiert die Kultivatoren und die Tasche mit Gegenständen, die im Kampf verwendet werden können.
- Erzeugt das `CombatSystem`, welches die Interaktionen der Kultivatoren und des Gegners im Kampf regelt.
- Kontrolliert den Spielablauf über eine Schleife, die so lange läuft, bis entweder alle Helden besiegt sind oder alle Gegner gefallen sind.
- Gibt das Ergebnis des Kampfes aus, um den Spieler über den Ausgang zu informieren.

### Hilfsfunktionen:

- `bag()`: Initialisiert ein `Bag`-Objekt mit einer Auswahl an Gegenständen, die im Kampf eingesetzt werden können.
- `cultivators()`: Stellt eine Liste von Kultivatoren zusammen, ausgestattet mit individuellen Fähigkeiten und Aktionen.
- `enemiesAreDead()`: Prüft, ob alle Gegner besiegt wurden, was das Ende des Spiels signalisiert.

### Spielablauf:

1. Die Runden beginnen und das `CombatSystem` führt für jeden Kultivator und anschließend für den Gegner Aktionen aus.
2. Zwischen den Runden wird optional eine kurze Pause eingefügt, um den Spielern Zeit zum Lesen der Kampfergebnisse zu geben (`Thread.sleep(1000)`).
3. Nach jeder Runde wird überprüft, ob der Kampf weitergeführt werden soll oder ob ein Sieger feststeht.

### Spielende:

- Bei Niederlage aller Kultivatoren wird eine Nachricht ausgegeben, dass die Dämonen siegreich waren.
- Bei Sieg über alle Feinde wird der Triumph der Taoisten verkündet.

Die `main.kt` bietet die strukturelle Grundlage für das Spiel, indem sie den Rahmen für die Spiellogik und die Interaktionen der Spielobjekte bereitstellt.

</details>

---

<details>
  <summary>1. Was sind abstrakte Klassen?</summary>

Eine abstrakte Klasse ist eine Klasse, die nicht direkt instanziiert werden kann und als Basis für andere Klassen dient. In deinem Code dient die `Cultivator`-Klasse als abstrakte Klasse. Sie definiert Eigenschaften und Methoden, die allen Kultivatoren gemeinsam sind, wie `healthPoints` und `attack()`. Andere Klassen wie `TaoistMage`, `Shaman` und `Geomancer` erben von `Cultivator` und implementieren spezifische Verhaltensweisen, die auf ihre einzigartige Rolle im Spiel zugeschnitten sind. Abstrakte Klassen werden oft verwendet, um einen gemeinsamen Vertragsentwurf bereitzustellen, den alle abgeleiteten Klassen befolgen müssen.

</details>

---

<details>
  <summary>2. Was sind Singletons?</summary>

Ein Singleton ist ein Entwurfsmuster, das sicherstellt, dass eine Klasse nur eine einzige Instanz hat. In deinem Code wird das Singleton-Muster in den Klassen `DualisticDemon` und `DualMinion` verwendet. Dies wird erreicht, indem der Konstruktor privat gemacht wird und eine statische Methode `getInstance()` bereitgestellt wird, die die einzige Instanz verwaltet und zurückgibt. Dies ist besonders nützlich, um eine konsistente Kontrolle über Ressourcen zu gewährleisten, die im Spiel einmalig sein sollten, wie der Endgegner und der Unterboss.

</details>

---

<details>
  <summary>3. Was sind Companion-Objekte?</summary>

Companion-Objekte in Kotlin sind ein Feature, das es erlaubt, Mitglieder (Methoden oder Eigenschaften) zu definieren, die an eine Klasse gebunden sind, statt an Instanzen der Klasse. In deinem Code wird dies genutzt, um das Singleton-Muster für `DualisticDemon` und `DualMinion` zu implementieren. Das Companion-Objekt enthält die `getInstance()` Methode und die private Instanzvariable. Es erlaubt den Zugriff auf die `getInstance()` Methode mit dem Klassennamen anstatt einer Instanz und unterstützt somit das Singleton-Entwurfsmuster, indem es die Erstellung einer einzigen Instanz der Klasse innerhalb der Anwendung sicherstellt.

</details>

