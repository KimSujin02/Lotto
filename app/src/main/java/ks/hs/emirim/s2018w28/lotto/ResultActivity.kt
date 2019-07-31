package ks.hs.emirim.s2018w28.lotto

import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_result.*
import java.text.SimpleDateFormat
import java.util.*

class ResultActivity : AppCompatActivity() {

    val lottoImageStartId = R.drawable.ball_01

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getIntegerArrayListExtra("result")

        val name = intent.getStringExtra("name")

        val constellation = intent.getStringExtra("constellation")

        ResultLabel.text = "랜덤으로 생성된 \n로또번호 입니다"

        if(!TextUtils.isEmpty(name)) {
            ResultLabel.text = "${name}님의 \n${SimpleDateFormat("yyyy년 MM월 dd일").format(Date())}\n로또 번호입니다."
        }

        if(!TextUtils.isEmpty(constellation)) {
            ResultLabel.text = "${constellation}의 \n${SimpleDateFormat("yyyy년 MM월 dd일").format(Date())}\n로또 번호입니다."
        }

        result?.let {
            //이미지 업데이트, 정렬
            updateLottoBallImage(result.sortedBy {it})
        }

//
//        goButton.setOnClickListener {
//            val intent = Intent(this, ResultActivity::class.java)
//
//            intent.putIntegerArrayListExtra("result", ArrayList(getLottoNumbersFromHash(editText.text.toString())))
//
//            startActivity(intent)
//        }


    }


    fun updateLottoBallImage(result: List<Int>) {
        if(result.size < 6) return

        imageView01.setImageResource(lottoImageStartId + (result[0] - 1 ))
        imageView02.setImageResource(lottoImageStartId + (result[1] - 1 ))
        imageView03.setImageResource(lottoImageStartId + (result[2] - 1 ))
        imageView04.setImageResource(lottoImageStartId + (result[3] - 1 ))
        imageView05.setImageResource(lottoImageStartId + (result[4] - 1 ))
        imageView06.setImageResource(lottoImageStartId + (result[5] - 1 ))

    }
}
