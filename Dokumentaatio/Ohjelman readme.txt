Itse ohjelman readme:
Koska aiheenani on j‰rjest‰misalgoritmien vertailu, en n‰hnyt tarpeelliseksi tehd‰ graafista k‰yttˆliittym‰‰. 

Tekemi‰ni luokkia voisi k‰ytt‰‰ esim. muiden ohjelmien kirjastoina.

Luokkien toimivuutta voi kuitenkin testata avaamalla luokat yhten‰ projektina esim. NetBeansissa ja printtailemalla testitaulukoita
ennen j‰rjest‰mist‰ ja sen j‰lkeen. Tiralabra.java -tiedostossa on demossani k‰ytt‰mi‰ esimerkkej‰, joita voi k‰ytt‰‰ ohjelman toimivuuden testaamiseen.

Jokainen j‰rjest‰misalgoritmiluokka (OptimizedSort.java, InsertionSort.java, Quicksort.java ja Heap.java) sis‰lt‰‰ v‰hint‰‰n metodin sort(int[] array),
jolla parametrina annettu taulukko j‰rjestet‰‰n. Lis‰ksi ArrayOperations -luokka sis‰lt‰‰ joitain taulukon tutkimiseen ja testaamiseen liittyvi‰
hyˆdyllisi‰ metodeita.

Olen itse testannut toimivuuden vain avaamalla luokat projektina NetBeansissa. En tosin n‰e syyt‰, mikseiv‰t yksitt‰iset luokat toimisi esim. jonkun muun projektin 
osana, sill‰ yksitt‰iset j‰rjest‰misalgoritmiluokkani eiv‰t ole riippuvaisia mist‰‰n muusta luokasta. Tosin automaattinen testaus onnistuu vain, jos kaikki luokat
ovat yht‰ aikaa samassa projektissa, sill‰ testeiss‰ vertaillaan eri algoritmeja toisiinsa.