package com.example.myapplication.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.myapplication.R
import com.example.myapplication.models.BlogPost
import kotlinx.android.synthetic.main.layout_blog_list_item.view.*

class BlogRecyclerAdapter(_item: List<BlogPost>) :
    RecyclerView.Adapter<BlogRecyclerAdapter.RecyclerItemViewHolder>() {

    private var items: List<BlogPost> = ArrayList<BlogPost>()

    init {
        items = _item
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerItemViewHolder {

        return RecyclerItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_blog_list_item,
                parent,
                false
            )
        )

    }

    override fun getItemCount(): Int {

        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerItemViewHolder, position: Int) {

        when (holder) {
            is RecyclerItemViewHolder -> {
                holder.bind(items.get(position))
            }
        }
    }


    class RecyclerItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(blogPost: BlogPost) {

            itemView.blog_title.text = blogPost.title
            itemView.blog_author.text = blogPost.userNmae

            var requestOption = RequestOptions()
                .placeholder(R.drawable.sample)
                .error(R.drawable.sample)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOption)
                .load(blogPost.image)
                .into(itemView.blog_image)


        }
    }
}