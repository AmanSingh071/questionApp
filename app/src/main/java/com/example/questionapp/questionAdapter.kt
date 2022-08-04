package com.example.questionapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class questionAdapter(val quesModel:MutableList<Question>):RecyclerView.Adapter<quesviewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): quesviewholder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.layoutquestiondisplay,parent,false)
        return quesviewholder(view)
    }

    override fun onBindViewHolder(holder: quesviewholder, position: Int) {
     return holder.bindView(quesModel[position])
    }

    override fun getItemCount(): Int {
       return quesModel.size
    }
}
class quesviewholder(itemView: View):RecyclerView.ViewHolder(itemView){
    private var questxt:TextView=itemView.findViewById(R.id.questiontxt)
    private var optinatxt:TextView=itemView.findViewById(R.id.optionAtxt)
    private var optionbtxt:TextView=itemView.findViewById(R.id.optionBtxt)
    private var optionctxt:TextView=itemView.findViewById(R.id.optionCtxt)
    private var optiondtxt:TextView=itemView.findViewById(R.id.optionDtxt)
    private var ansoptiontxt:TextView=itemView.findViewById(R.id.anstxt)
    private var answertxt:TextView=itemView.findViewById(R.id.answertxt)
    private var quesnotxt:TextView=itemView.findViewById(R.id.queno)
    private var clickheretxt:TextView=itemView.findViewById(R.id.display)



    fun bindView(questimodel:Question){
        quesnotxt.text= questimodel.id.toString()
        questxt.text=questimodel.Question
        optinatxt.text="A   "+questimodel.Optionsa
        optionbtxt.text="B   "+questimodel.Optionb
        optionctxt.text="C   "+questimodel.Optionc
        optiondtxt.text="D   "+questimodel.Optiond
        ansoptiontxt.visibility=View.GONE
        answertxt.visibility=View.GONE
        var display:Boolean=false
         clickheretxt.setOnClickListener {

             if (display){
                 ansoptiontxt.text=questimodel.CorrectOption +"  :Correct Answer"
                 ansoptiontxt.visibility=View.VISIBLE

                 answertxt.text="Hints & Solutions\n \n"+questimodel.Answer
                 answertxt.visibility=View.VISIBLE
                 display=false
             }
             else
             {
                 ansoptiontxt.text=questimodel.CorrectOption +"  :Correct Answer"
                 ansoptiontxt.visibility=View.GONE

                 answertxt.text="Hints & Solutions\n \n"+questimodel.Answer
                 answertxt.visibility=View.GONE
                 display=true
             }

         }




    }
}