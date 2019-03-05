package ifpb.edu.br.appfarmaciapopular;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MedicamentosFragment extends Fragment {

    ArrayList<String> medicamentos = new ArrayList<String>();


    public MedicamentosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_medicamentos, container, false);
    }

    private ArrayList<String> preencherDados(ArrayList<String> list) {
        list.add("medicamento 1");
        list.add("medicamento 2");
        list.add("medicamento 3");
        list.add("medicamento 4");
        list.add("medicamento 5");

        return list;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        preencherDados(medicamentos);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, medicamentos);
        ListView listView = view.findViewById(R.id.list_medicamentos);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                getFragmentManager()
                        .beginTransaction().replace(R.id.fragment,  new MedicamentoInfoFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });
    }
}
