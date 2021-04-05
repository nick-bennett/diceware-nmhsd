package us.nm.state.hsd.diceware.service;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BundleProvider implements WordProvider {

  private final ResourceBundle bundle;
  
  @Autowired
  public BundleProvider(ResourceBundle bundle) {
    this.bundle = bundle;
  }

  @Override
  public Collection<String> words() {
    return bundle
        .keySet()
        .parallelStream()
        .map(bundle::getString)
        .collect(Collectors.toList());
//    Set<String> keySet = bundle.keySet();
//    List<String> values = new LinkedList<>();
//    for (String key : keySet) {
//      values.add(bundle.getString(key));
//    }
//    return values;
  }

}
