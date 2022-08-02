package kr.ac.kumoh.ce.s20191074.mygraphicsviewmodel

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class GraphicView : View {
    private val p = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL_AND_STROKE
        strokeCap = Paint.Cap.ROUND
        strokeWidth = 10F
    }

    private val activity = context as MainActivity
    private var bmp = BitmapFactory.decodeResource(resources, R.drawable.dora)

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        bmp = Bitmap.createScaledBitmap(bmp, 100, 100, false)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val list = activity.getPositionList()

        //선 그리기
//        var oldP: PointF? = null
//        for (i in 0 until list.size){
//            //canvas.drawCircle(list[i].x, list[i].y, 30F, p)
//            oldP?.run {
//                canvas.drawLine(this.x, this.y, list[i].x, list[i].y, p)
//            }
//            oldP = list[i]
//        }

        for (i in 0 until list.size)
            canvas.drawBitmap(bmp, list[i].x, list[i].y, p)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN,
            MotionEvent.ACTION_MOVE -> {
                activity.addPosition(event.x, event.y)
                invalidate()    //중요
            }
        }
        return true
    }
}