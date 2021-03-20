package unasat.sr.buysmart.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import java.time.LocalDateTime;
import java.util.Date;

import unasat.sr.buysmart.DatabaseManager.Dao.GlobalDAO;
import unasat.sr.buysmart.Entities.Order;
import unasat.sr.buysmart.Entities.Product;
import unasat.sr.buysmart.Entities.User;
import unasat.sr.buysmart.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProductDetailsFragment} factory method to
 * create an instance of this fragment.
 */
public class ProductDetailsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String ARG_PROD_ID = "productId";

    // TODO: Rename and change types of parameters
    private int mProd_id;
    private TextView productTextViewDetailTextView, priceTextViewDetailTextView;
    private Button orderBtn;

    private User user;
    private Product product;

    public ProductDetailsFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            mProd_id = getArguments().getInt(ARG_PROD_ID);

            System.out.println("Details " + mProd_id);
//            System.out.println(mUsername);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_product_details, container, false);
        GlobalDAO globalDAO = new GlobalDAO(v.getContext());
//        user = globalDAO.findByUsername(mUsername);
        product = globalDAO.findProductById(String.valueOf(mProd_id));
        productTextViewDetailTextView = v.findViewById(R.id.productTextViewDetailTextView);
        priceTextViewDetailTextView = v.findViewById(R.id.priceTextViewDetailTextView);
        productTextViewDetailTextView.setText(product.getName());
        priceTextViewDetailTextView.setText(String.valueOf(product.getPrice()));
        orderBtn = v.findViewById(R.id.orderBtn);


//        orderBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                addOrder(v);
//            }
//        });
        return v;
    }

//    public void addOrder(View view) {
//        Context context = view.getContext();
//        GlobalDAO globalDAO = new GlobalDAO(context);
//        User user = globalDAO.findByUsername(mParam3);
//        if(user != null) {
//            Order order = new Order();
//            order.setCustomerId(user.getUserId());
//            order.setProductId(mParam4);
//            Date date = new Date();
//            order.setOrderedDate(String.valueOf(date));
//            globalDAO.addOrder(order);
//            System.out.println("Added order for " + mParam4);
//        } else {
//            System.out.println("Failed to add ordered.");
//        }
//    }
}