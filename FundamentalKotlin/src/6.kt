fun main(){
    val openHours = 7
    val now = 7
    val office: String
    office = if (now > 7) {
        "Kantin sedang buka"
    } else if (now == openHours){
        "Mohon tunggu, kantin sedang disiapkan"
    } else {
        " Kantin sedang tutup"
    }
    print(office)
}