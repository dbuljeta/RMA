<h2>Razvoj mobilnih aplikacija DZ2</h2>

U ovoj zadaći sam kreirao aplikaciju za konverziju mjernih jedinica po izboru. Ja sam izabrao :
temperaturu, udaljenost, brzinu te masu. Samim tim aplikacija se sastoji od ukupno 6 Activity-a, 
odnosno jednog glavnog koji se pokreće prilikom pokretanja aplikacije na kojemu odabiremu koju konverziju
želimo obaviti klikom na nju. Unutar bilo kojeg od 4 Activitya konverzije imaju dva spinnera na kojima odabiremo
mjerne jedinice vrijednosti koju želimo pretvoriti i u koju mjernu jedinicu je želimo pretvoriti. Vrijednosti unutar spinnera 
su određeni unutar xml-datoteke pojedinog activitya, odnosno entries koji sam povezao sa string datotekom te spremljenim poljem stringova
unutar string datoteke. Nakon klika na gumb Convert pokreće se Rezultantni Activity koji je zajednički svim Activity-ma konverzije. 
Na osnovu naziva Activtya koji je pokrenuo rezultantni Activity na njemu se postavljaju naslov, te rezultati konverzije zajedno s mjernim jedinicama.
Prilikom zakretanja mobilnog uređaja, na Activtye konverzije je bilo potrebno staviti scrool view, kako nam ne bi bili 
odsječeni određeni rezultantni zasloni. Za dohvaćanje podataka u Rezultantnom Activityu iz prethodnog koristio sam klasu Bundle.

Prilikom izrade zadaće koristio sam se linkovima:
http://stackoverflow.com/questions/5241660/how-can-i-add-items-to-a-spinner-in-android
http://stackoverflow.com/questions/6674341/how-to-use-scrollview-in-android
https://developer.android.com/reference/android/os/Bundle.html
https://developer.android.com/reference/android/content/Intent.html
