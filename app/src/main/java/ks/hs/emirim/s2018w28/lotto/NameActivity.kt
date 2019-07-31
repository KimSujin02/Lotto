package ks.hs.emirim.s2018w28.lotto

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_name.*
import ks.hs.emirim.s2018w28.lotto.LottoNumberMaker.getLottoNumbersFromHash
import java.util.*

class NameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)

        goButton.setOnClickListener {
            if (TextUtils.isEmpty(editText.text.toString())) {
                Toast.makeText(applicationContext, "이름을 입력하세요.", Toast.LENGTH_LONG).show()

                return@setOnClickListener
            }
            val intent = Intent(this, ResultActivity::class.java)
            intent.putIntegerArrayListExtra("result", ArrayList(getLottoNumbersFromHash(editText.text.toString())))

            intent.putExtra("name", editText.text.toString())

            startActivity(intent)
        }

        backButton.setOnClickListener {
            finish()
//        }
//
//        //입력받은 이름에 대한 해시코드를 사용하여 로또 번호를 섞고 결과를 반환한다.
//        fun getLottoNumbersFromHash(name: String): MutableList<Int> {
//            val list = mutableListOf<Int>()
//
//            for (number in 1..45) {
//                list.add(number)
//            }
//
//            val targetString = SimpleDateFormat("yyyy-MM-dd", Locale.KOREA).format(Date()) + name
//
//            list.shuffle(Random(name.hashCode().toLong()))
//
//            return list.subList(0, 6)
//        }
        }
    }
}
