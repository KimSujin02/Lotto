package ks.hs.emirim.s2018w28.lotto

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(applicationContext, "MainActivity입니다.", Toast.LENGTH_LONG).show()

        //랜덤으로 번호 생성 카드의 클릭 이벤트 리스너
        randomCard.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)

            intent.putIntegerArrayListExtra("result", ArrayList(LottoNumberMaker.getShuffleLottoNumbers()))
            startActivity(intent)
        }

        constellationCard.setOnClickListener {
            startActivity(Intent(this,ConstellationActivity::class.java))
        }

        nameCard.setOnClickListener {
            startActivity(Intent(this, NameActivity::class.java))
        }
//
//        fun getRandomLottoNumber():Int {
//            return Random().nextInt(45) +1
//        }
//
//        fun getRandomLottoNumbers(): MutableList<Int> {
//            val lottoNumbers = mutableListOf<Int>()
//
//            for(i in 1..6) {
//                var number = 0
//                do {
//                    number = getRandomLottoNumber()
//                }while (lottoNumbers.contains(number))
//                lottoNumbers.add(number)
//            }
//            return lottoNumbers
//        }
//
//        randomCard.setOnClickListener {
//            val intent = Intent(this, ResultActivity::class.java)
//
//            intent.putIntegerArrayListExtra("result", ArrayList(getRandomLottoNumbers()))
//
//            startActivity(intent)
//        }
//
//        fun getShuffleLottoNumbers(): MutableList<Int> {
//            val list = mutableListOf<Int>()
//
//            for (number in 1..45) {
//                list.add(number)
//            }
//            list.shuffle() //무작위로 섞는다 이말
//
//            return  list.subList(0, 6)
//        }
//
//        intent.putIntegerArrayListExtra("result", ArrayList(getShuffleLottoNumbers()))
    }
}
