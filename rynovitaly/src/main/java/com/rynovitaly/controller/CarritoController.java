
package com.rynovitaly.controller;


import com.rynovitaly.domain.Producto;
import com.rynovitaly.domain.Item;
import com.rynovitaly.service.ProductoService;
import com.rynovitaly.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
@Slf4j
public class CarritoController {
    @Autowired
    private ItemService itemService;
    @Autowired
    private ProductoService articuloService;
    
    //para el carrito
    @GetMapping("/carrito/listado")
    public String inicio (Model model) {
        var items = itemService.getItems();
        model.addAttribute("items",items);
        var carritoTotalVenta=0;
        for(Item i : items) {
            carritoTotalVenta += (i.getCantidad()*i.getPrecio());
        }
        model.addAttribute("carritoTotal",carritoTotalVenta);
        return"/carrito/listado";
    
    
    }
    
    //para agregar articulos al carrito
    @GetMapping("/carrito/agregar/{idProducto}")
    public ModelAndView agregararticulo (Model model , Item item) {
        Item item2 = itemService.getItem(item);
        if(item2==null){
            Producto articulo = articuloService.getProducto(item);
            item2 = new Item(articulo);
        }
        itemService.save(item2);
        var lista = itemService.getItems();
        var totalCarritos  =0;
        var carritoTotalVenta =0;
        for (Item i : lista) {
            totalCarritos+=i.getCantidad();
            carritoTotalVenta += (i.getCantidad() * i.getPrecio());
        }
        model.addAttribute("listaItems",lista);
        model.addAttribute("listaTotal",totalCarritos);
        model.addAttribute("carritoTotal",carritoTotalVenta);
        return new  ModelAndView("/carrito/fragmentosCarrito :: verCarrito");
        
        
    
    }
    //para modificar un articuli del carrito
    @GetMapping("/carrito/modificar/{idProducto}")
    public String modificarCarrito (Item item , Model model) {
        item = itemService.getItem(item);
        model.addAttribute("item",item);
        return "/carrito/modificar";
     
    }
    
    //para eliminar un elemento del carrito
      @GetMapping("/carrito/eliminar/{idProducto}")
    public String eliminarItem (Item item ) {
        itemService.delete(item);
        return "redirect:/carrito/listado";
    }
    
    //para actualizar un elemento en el carrito
    @PostMapping("/carrito/guardar")
    public String guardarItem (Item item) {
        itemService.actualiza(item);
        return "redirect:/carrito/listado";
    
    
    }
    
    //para facturar los articulos del carrto ..no implementado..
       @GetMapping("/facturar/carrito")
    public String facturarCarrito ( ) {
        itemService.facturar();
        return "redirect:/";
        
    }
    
}