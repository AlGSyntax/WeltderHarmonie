/**
 * ShopItem ist eine spezialisierte Version eines Items, das in einem ItemShop zum Kauf angeboten wird.
 * Es enthält zusätzliche Eigenschaften wie Kosten und verfügbare Menge, die für den Handel im Spiel relevant sind.
 *
 * @property name Der eindeutige Name des ShopItems.
 * @property effectDescription Die Beschreibung des Effekts, den das Item hat.
 * @property cost Die Kosten des Items in Energiepunkten.
 * @property quantity Die Anzahl, wie oft das Item im Shop verfügbar ist.
 * @constructor Erstellt ein neues ShopItem, das im ItemShop zum Verkauf angeboten werden kann.
 */
class ShopItem(name:String, effectDescription: String,val cost:Int, var quantity:Int):Item(name,effectDescription) {



    /**
     * Erstellt eine Kopie dieses ShopItems mit einer spezifischen Menge.
     * Diese Methode wird typischerweise verwendet, um eine bestimmte Anzahl von Items dem Inventar eines Cultivators hinzuzufügen.
     *
     * @param quantity Die Menge des Items, die in die Kopie übernommen werden soll. Standardmäßig wird die aktuelle Menge verwendet.
     * @return Eine neue Instanz von ShopItem mit der angegebenen Menge.
     */
    fun copy(quantity: Int = this.quantity):ShopItem{
        return ShopItem(name,effectDescription, cost, quantity)
    }
}