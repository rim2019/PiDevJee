using Service;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using WebApp.Models;

namespace WebApp.Controllers
{
    public class PackFrontController:Controller
    {
        PackService PS;

        public PackFrontController()
        {
            PS = new PackService();
            //ProduitS = new ProduitService();
        }

        public ActionResult Affichage(String PriceMin,String PriceMax )
        {
            if (PriceMin != null && PriceMax!=null)
            {
                return View(PS.GetAll().Where(a => a.NouveauPrixTotaleProduit > double.Parse(PriceMin)&& a.NouveauPrixTotaleProduit < double.Parse(PriceMax)));
            }

            return View(PS.GetAll());

        }

        // GET: Product/Details/5
        public ActionResult Details(int id)
        {
            PackModels pm = new PackModels();
            var x = PS.GetById(id);
            pm.ListProduits = x.Produits;
            return View(pm);
        }



    }
}